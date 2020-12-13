package subway.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubwayMapControllerTest {

    private StationRepository stationRepository;
    private LineRepository lineRepository;
    private StationService stationService;
    private LineService lineService;
    private SubwayMapController subwayMapController;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository(new ArrayList<>());
        lineRepository = new LineRepository(new ArrayList<>());
        stationService = new StationService(stationRepository);
        lineService = new LineService(lineRepository);
        subwayMapController = new SubwayMapController(stationService, lineService);
        subwayMapController.addStationByName("이수역");
        subwayMapController.addStationByName("대화역");
        subwayMapController.addLine(new LineDto("1호선", "이수역", "대화역"));
    }

    @DisplayName("Station 등록 성공")
    @Test
    void addStationByName_성공한다() {
        subwayMapController.addStationByName("테스트역");

        List<String> stationNames = subwayMapController.getStationNames();

        assertThat(stationNames).hasSameElementsAs(Arrays.asList("이수역", "대화역", "테스트역"));
    }

    @DisplayName("Station 삭제 성공")
    @Test
    void deleteStationByName_삭제_성공한다() {
        subwayMapController.addStationByName("테스트역");
        int beforeStationCounts = stationRepository.findAll().size();

        subwayMapController.deleteStationByName("테스트역");
        int afterStationCounts = stationRepository.findAll().size();

        assertThat(beforeStationCounts).isGreaterThan(afterStationCounts);
    }

    @DisplayName("Line 등록 성공")
    @Test
    void addLine_성공한다() {
        stationService.addStationByName("강릉역");
        LineDto lineDto = new LineDto("11호선", "이수역", "강릉역");
        subwayMapController.addLine(lineDto);

        String name = subwayMapController.getLineNames()
                .get(1);

        assertThat(name).isEqualTo("11호선");
    }

    @DisplayName("Line 삭제 성공")
    @Test
    void deleteLineByName_성공한다() {
        int beforeLineCounts = lineRepository.findAll().size();

        subwayMapController.deleteLineByName("1호선");
        int afterLineCounts = lineRepository.findAll().size();

        assertThat(beforeLineCounts).isGreaterThan(afterLineCounts);
    }

    @DisplayName("구간 등록 성공")
    @Test
    void addSection_성공한다() {
        subwayMapController.addStationByName("강남역");
        SectionDto sectionDto = new SectionDto("1호선", "강남역", 1);
        subwayMapController.addSection(sectionDto);

        List<String> stationNames = lineRepository.findByName("1호선")
                .get()
                .getStationNames();

        assertThat(stationNames).hasSameElementsAs(Arrays.asList("강남역", "이수역", "대화역"));
    }

    @DisplayName("구간 삭제 성공")
    @Test
    void deleteSection_성공한다() {
        subwayMapController.addStationByName("강남역");
        SectionDto sectionDto = new SectionDto("1호선", "강남역", 1);
        subwayMapController.addSection(sectionDto);
        subwayMapController.deleteSection(sectionDto);

        List<String> stationNames = lineRepository.findByName("1호선")
                .get()
                .getStationNames();

        assertThat(stationNames).hasSameElementsAs(Arrays.asList("이수역", "대화역"));
    }
}
