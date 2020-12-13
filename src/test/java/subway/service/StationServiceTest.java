package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class StationServiceTest {

    private StationService stationService;
    private StationRepository stationRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository(new ArrayList<>());
        stationService = new StationService(stationRepository);
        stationService.addStationByName("이수역");
    }

    @DisplayName("Station 등록 성공")
    @Test
    void addStationByName_성공한다() {
        String name = stationService.getStationNames().get(0);

        assertThat(name).isEqualTo("이수역");
    }

    @DisplayName("Station 등록 실패 : 중복된 역 이름인 경우")
    @Test
    void addStationByName_중복된_이름_예외가_발생한다() {
        assertThatCode(() -> {
            stationService.addStationByName("이수역");
        }).isInstanceOf(StationDuplicationException.class)
                .hasMessage("이미 등록된 역 이름입니다.");
    }

    @DisplayName("Station 삭제 실패 : 등록되지 않은 역 이름인 경우")
    @Test
    void deleteStationByName_등록되지_않은_역_예외가_발생한다() {
        assertThatCode(() -> {
            stationService.deleteStationByName("없는역");
        }).isInstanceOf(CannotFindStationException.class)
                .hasMessage("등록되지 않은 지하철 역 이름을 입력하셨습니다.");
    }

    @DisplayName("Station 삭제 실패 : 이미 노선에 등록된 역인 경우")
    @Test
    void deleteStationByName_노선에_등록된_역_예외가_발생한다() {
        Station station = new Station("테스트역");
        station.registerAsSection();
        stationRepository.save(station);

        assertThatCode(() -> {
            stationService.deleteStationByName("테스트역");
        }).isInstanceOf(CannotDeleteStationException.class)
                .hasMessage("노선에 등록된 지하철 역은 삭제할 수 없습니다.");
    }

    @DisplayName("Station 삭제 성공")
    @Test
    void deleteStationByName_삭제가_성공한다() {
        stationService.addStationByName("테스트역");

        boolean isRemoved = stationService.deleteStationByName("테스트역");

        assertThat(isRemoved).isTrue();
    }

    @DisplayName("DTO에 저장된 종점역 이름들로 Sections를 생성해 반환")
    @Test
    void createSections_Sections가_반환된다() {
        stationService.addStationByName("광운대역");
        LineDto lineDto = new LineDto("1호선", "이수역", "광운대역");

        assertThatCode(() -> {
            stationService.createSections(lineDto);
        }).doesNotThrowAnyException();
    }

    @DisplayName("DTO에 저장된 종점 역들이 등록되지 않은 역들인 경우")
    @Test
    void createSections_등록되지_않은_종점_예외가_발생한다() {
        LineDto lineDto = new LineDto("1호선", "이수역", "광운대역");

        assertThatCode(() -> {
            stationService.createSections(lineDto);
        }).isInstanceOf(CannotFindStationException.class)
                .hasMessage("등록되지 않은 지하철 역 이름을 입력하셨습니다.");
    }
}
