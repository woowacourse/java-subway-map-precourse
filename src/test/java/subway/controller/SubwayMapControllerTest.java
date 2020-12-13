package subway.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Station;
import subway.domain.entity.StationNameException;
import subway.domain.repository.StationRepository;
import subway.service.CannotDeleteStationException;
import subway.service.CannotFindStationException;
import subway.service.StationDuplicationException;
import subway.service.StationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SubwayMapControllerTest {

    private final StationRepository stationRepository = new StationRepository(new ArrayList<>());
    private final StationService stationService = new StationService(stationRepository);
    private final SubwayMapController subwayMapController = new SubwayMapController(stationService);

    @BeforeEach
    void setUp() {
        subwayMapController.addStationByName("이수역");
    }

    @AfterEach
    void tearDown() {
        subwayMapController.deleteStationByName("이수역");
    }

    @DisplayName("Station 등록 성공")
    @Test
    void addStationByName_성공한다() {
        subwayMapController.addStationByName("테스트역");

        List<String> stationNames = subwayMapController.getStationNames();
        subwayMapController.deleteStationByName("테스트역");

        assertThat(stationNames).hasSameElementsAs(Arrays.asList("이수역", "테스트역"));
    }

    @DisplayName("Station 삭제 성공")
    @Test
    void deleteStationByName_삭제_성공한다() {
        subwayMapController.addStationByName("테스트역");
        int beforeStationCounts = subwayMapController.getStationNames().size();

        subwayMapController.deleteStationByName("테스트역");
        int afterStationCounts = subwayMapController.getStationNames().size();

        assertThat(beforeStationCounts).isGreaterThan(afterStationCounts);
    }

    @DisplayName("Station 등록 실패 : 이름의 형식이 잘못된 경우")
    @Test
    void addStationByName_잘못된_이름_예외가_발생한다() {
        assertThatCode(() -> {
            subwayMapController.addStationByName("역");
        }).isInstanceOf(StationNameException.class)
                .hasMessage("지하철 역 이름은 공백이 아닌 2글자 이상이어야 합니다.");
    }

    @DisplayName("Station 등록 실패 : 중복된 역 이름인 경우")
    @Test
    void addStationByName_중복된_이름_예외가_발생한다() {
        assertThatCode(() -> {
            subwayMapController.addStationByName("이수역");
        }).isInstanceOf(StationDuplicationException.class)
                .hasMessage("이미 등록된 역 이름입니다.");
    }

    @DisplayName("Station 삭제 실패 : 등록되지 않은 역 이름인 경우")
    @Test
    void deleteStationByName_등록되지_않은_역_예외가_발생한다() {
        assertThatCode(() -> {
            subwayMapController.deleteStationByName("없는역");
        }).isInstanceOf(CannotFindStationException.class)
                .hasMessage("등록되지 않은 지하철 역 이름을 입력하셨습니다.");
    }

    @DisplayName("Station 삭제 실패 : 이미 노선에 등록된 역인 경우")
    @Test
    void deleteStationByName_노선에_등록된_역_예외가_발생한다() {
        Station station = new Station("등록된역");
        stationRepository.save(station);
        station.registerAsSection();

        assertThatCode(() -> {
            subwayMapController.deleteStationByName("등록된역");
        }).isInstanceOf(CannotDeleteStationException.class)
                .hasMessage("노선에 등록된 지하철 역은 삭제할 수 없습니다.");

        stationRepository.delete(station);
    }
}
