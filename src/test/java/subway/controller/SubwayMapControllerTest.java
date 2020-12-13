package subway.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.StationNameException;
import subway.domain.repository.StationRepository;
import subway.service.StationDuplicationException;
import subway.service.StationService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatCode;

class SubwayMapControllerTest {

    private final StationRepository stationRepository = new StationRepository(new ArrayList<>());
    private final StationService stationService = new StationService(stationRepository);
    private final SubwayMapController subwayMapController = new SubwayMapController(stationService);
    
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
        subwayMapController.addStationByName("이수역");

        assertThatCode(() -> {
            subwayMapController.addStationByName("이수역");
        }).isInstanceOf(StationDuplicationException.class)
                .hasMessage("이미 등록된 역 이름입니다.");
    }
}
