package subway.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import subway.domain.Line;
import subway.domain.LineName;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

class ManageControllerTest {

    private ManageController manageController;

    @BeforeEach
    public void initManageController() {
        StationRepository secondLineStationRepository = new StationRepository().addStations("봉천역", "강남역", "잠실역");

        LineRepository lineRepository =
                new LineRepository().addLine(new Line(new LineName("2호선"), secondLineStationRepository));

        StationRepository thirdLineStationRepository = new StationRepository().addStations("양재역", "교대역");

        manageController = new ManageController(lineRepository, thirdLineStationRepository);
    }

    @Test
    @DisplayName("새로운 역 추가 테스트")
    public void addStation_NewStation_StationAdded() {

        // when
        manageController = manageController.addStation("대치역");

        //then
        assertThat(manageController.stations().stationNames()).containsExactly("양재역", "교대역", "대치역");
    }

    @Test
    @DisplayName("기존 역 삭제 테스트")
    public void removeStation_OldStation_StationRemoved() {

        // when
        manageController = manageController.removeStation("교대역");

        //then
        assertThat(manageController.stations().stationNames()).containsExactly("양재역");
    }

    @Test
    @DisplayName("새로운 노선 추가 테스트")
    public void addLine_NewLine_LineAdded() {

        // when
        manageController = manageController.addLine("1호선", "인천역", "소요산역");

        //then
        assertThat(manageController.lines().lineNames()).containsExactly("2호선", "1호선");
    }
}