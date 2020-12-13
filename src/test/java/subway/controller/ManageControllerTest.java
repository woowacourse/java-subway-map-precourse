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
}