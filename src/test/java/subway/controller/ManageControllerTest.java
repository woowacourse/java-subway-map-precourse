package subway.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class ManageControllerTest {

    private ManageController manageController;

    @BeforeEach
    public void initManageController() {
        manageController = initializeWithEmptyStations();
    }

    @Test
    @DisplayName("Manage Controller 초기화 테스트")
    public void initialize_ManageController_InitializedManageController() {

        // when
        ManageController hasStationsManageController = ManageController.initialize();

        //then
        assertThat(hasStationsManageController.stations().stationNames())
                .containsExactly("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

        assertThat(hasStationsManageController.lines().lineNames())
                .containsExactly("2호선", "3호선", "신분당선");

        assertThat(hasStationsManageController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("교대역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("새로운 역 추가 테스트")
    public void addStation_NewStation_StationAdded() {

        // when
        manageController = manageController.addStation("대치역");

        //then
        assertThat(manageController.stations().stationNames()).containsExactly("대치역");
    }

    @Test
    @DisplayName("기존 역 삭제 테스트")
    public void removeStation_OldStation_StationRemoved() {

        // given
        manageController = manageController.addStation("대치역");

        // when
        manageController = manageController.removeStation("대치역");

        //then
        assertThat(manageController.stations().stationNames()).isEmpty();
    }

    @Test
    @DisplayName("새로운 노선 추가 테스트")
    public void addLine_NewLine_LineAdded() {

        // when
        manageController = manageController.addLine("1호선", "인천역", "소요산역");

        //then
        assertThat(manageController.lines().lineNames())
                .containsExactly("2호선", "3호선", "신분당선", "1호선");
    }

    @Test
    @DisplayName("기존 노선 삭제 테스트")
    public void removeLine_OldLine_LineRemoved() {

        // when
        manageController = manageController.removeLine("2호선");

        //then
        assertThat(manageController.lines().lineNames()).containsExactly("3호선", "신분당선");
    }

    @Test
    @DisplayName("새로운 구간 추가 테스트")
    public void addRange_NewRange_RangeAdded() {

        // when
        manageController = manageController.addRange("2호선", "신림역", 1);

        //then
        assertThat(manageController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("교대역", "신림역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("기존 구간 삭제 테스트")
    public void removeRange_OldRange_RangeRemoved() {

        // when
        manageController = manageController.removeRange("2호선", "교대역");

        //then
        assertThat(manageController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("강남역", "역삼역");
    }

    public static ManageController initializeWithEmptyStations() {
        String[] secondLine = {"교대역", "강남역", "역삼역"};
        String[] thirdLine = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] sinbundangLine = {"강남역", "양재역", "양재시민의숲역"};

        LineRepository lineRepository = new LineRepository()
                .addLine("2호선", secondLine)
                .addLine("3호선", thirdLine)
                .addLine("신분당선", sinbundangLine);

        return new ManageController(lineRepository, new StationRepository());
    }
}