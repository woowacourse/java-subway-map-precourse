package subway.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class ManagementControllerTest {

    private ManagementController managementController;

    @BeforeEach
    public void initManagementController() {
        managementController = initializeWithEmptyStations();
    }

    @Test
    @DisplayName("Manage Controller 초기화 테스트")
    public void initialize_ManagementController_InitializedManagementController() {

        // when
        ManagementController hasStationsManagementController = ManagementController.initialize();

        //then
        assertThat(hasStationsManagementController.stations().stationNames())
                .containsExactly("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

        assertThat(hasStationsManagementController.lines().lineNames())
                .containsExactly("2호선", "3호선", "신분당선");

        assertThat(hasStationsManagementController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("교대역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("새로운 역 추가 테스트")
    public void addStation_NewStation_StationAdded() {

        // when
        managementController = managementController.addStation("대치역");

        //then
        assertThat(managementController.stations().stationNames()).containsExactly("대치역");
    }

    @Test
    @DisplayName("기존 역 삭제 테스트")
    public void removeStation_OldStation_StationRemoved() {

        // given
        managementController = managementController.addStation("대치역");

        // when
        managementController = managementController.removeStation("대치역");

        //then
        assertThat(managementController.stations().stationNames()).isEmpty();
    }

    @Test
    @DisplayName("새로운 노선 추가 테스트")
    public void addLine_NewLine_LineAdded() {

        // when
        managementController = managementController.addLine("1호선", "인천역", "소요산역");

        //then
        assertThat(managementController.lines().lineNames())
                .containsExactly("2호선", "3호선", "신분당선", "1호선");
    }

    @Test
    @DisplayName("기존 노선 삭제 테스트")
    public void removeLine_OldLine_LineRemoved() {

        // when
        managementController = managementController.removeLine("2호선");

        //then
        assertThat(managementController.lines().lineNames()).containsExactly("3호선", "신분당선");
    }

    @Test
    @DisplayName("새로운 구간 추가 테스트")
    public void addSection_NewSection_SectionAdded() {

        // when
        managementController = managementController.addSection("2호선", "신림역", 1);

        //then
        assertThat(managementController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("교대역", "신림역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("기존 구간 삭제 테스트")
    public void removeSection_OldSection_SectionRemoved() {

        // when
        managementController = managementController.removeSection("2호선", "교대역");

        //then
        assertThat(managementController.lines().getStationNamesByLineName("2호선"))
                .containsExactly("강남역", "역삼역");
    }

    public static ManagementController initializeWithEmptyStations() {
        String[] secondLine = {"교대역", "강남역", "역삼역"};
        String[] thirdLine = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] sinbundangLine = {"강남역", "양재역", "양재시민의숲역"};

        LineRepository lineRepository = new LineRepository()
                .addLine("2호선", secondLine)
                .addLine("3호선", thirdLine)
                .addLine("신분당선", sinbundangLine);

        return new ManagementController(lineRepository, new StationRepository());
    }
}