package subway.line;

import org.junit.jupiter.api.*;
import subway.domain.Line;
import subway.domain.Station;
import subway.station.StationRepository;
import subway.station.StationRepositoryJava;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LineControllerTest {

    private LineController lineController;
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public LineControllerTest() {
        lineRepository = new LineRepositoryJava();
        stationRepository = new StationRepositoryJava();
        lineController = new LineController(lineRepository, stationRepository);
    }

    @BeforeEach
    private void addDummyStations() {
        List<Line> lines = getDummyLines();
        lines.forEach(line -> lineRepository.addLine(line));
    }

    @AfterEach
    private void deleteDummyStations() {
        List<Line> lines = lineRepository.lines();
        Set<Station> stations = stationRepository.stations();
        stations.forEach(station -> stationRepository.deleteStation(station));
        lines.forEach(line -> lineRepository.deleteLine(line));
    }

    @Test
    @DisplayName("노선 목록 가져오기")
    public void findAllLines() throws Exception {
        //given
        final int linesSize = 3;
        //when
        List<LineResponseDTO> lines = lineController.findLines();
        //then
        assertEquals(linesSize, lines.size());
    }

    @Test
    @DisplayName("잘못된 이름으로 라인을 만들 때")
    public void createLineWithWrongName() throws Exception {
        //given
        String expectedMessage = "지하철 노선 이름은 2 글자 이상이어야 합니다.";
        String name = "선";
        String startName = "구로역";
        String endName = "광명역";
        createLine(name, startName, endName);
        //when
        LineRequestDTO lineRequestDTO = new LineRequestDTO(name, startName, endName);
        //then
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.createLine(lineRequestDTO));
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("시작 역과 마지막 역 이름이 같을 때")
    public void createLineWithSameStationName() throws Exception {
        //given
        String expectedMessage = "서로 다른 역을 입력해주세요.";
        String name = "11호선";
        String startName = "구로역";
        String endName = "구로역";
        createLine(name, startName, endName);
        //when
        LineRequestDTO lineRequestDTO = new LineRequestDTO(name, startName, endName);
        //then
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.createLine(lineRequestDTO));
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("이미 등록되어 있는 이름으로 등록할 때")
    public void createLineWithDuplicateName() throws Exception {
        //given
        String expectedMessage = "중복된 이름입니다.";
        String duplicatedName = "1호선";
        String startName = "구로역";
        String endName = "광명역";
        createLine(duplicatedName, startName, endName);
        //when
        LineRequestDTO lineRequestDTO = new LineRequestDTO(duplicatedName, startName, endName);
        //then
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.createLine(lineRequestDTO));
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("등록되어 있지 않은 역을 등록할 때")
    public void createLineWithWrongStation() throws Exception {
        //given
        String expectedMessage = "역을 먼저 등록해주세요.";
        String name = "11호선";
        String startName = "구로역";
        String endName = "광명역";
        //when
        LineRequestDTO lineRequestDTO = new LineRequestDTO(name, startName, endName);
        //then
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.createLine(lineRequestDTO));
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("모든 유효성을 통과 이후 생성")
    public void createLineSuccess() throws Exception {
        //given
        String name = "11호선";
        String startName = "구로역";
        String endName = "광명역";
        createLine(name, startName, endName);
        //when
        LineRequestDTO lineRequestDTO = new LineRequestDTO(name, startName, endName);
        lineController.createLine(lineRequestDTO);
        //then
        assertTrue(lineRepository.findByName(name).isPresent());
    }

    private List<Line> getDummyLines() {
        return Arrays.asList(
                createLine("1호선", "인천역", "서울역"),
                createLine("2호선", "건대입구역", "강남역"),
                createLine("7호선", "도봉산역", "건대입구역")
        );
    }

    private Line createLine(String name, String startName, String endName) {
        Station start = Station.from(startName);
        Station end = Station.from(endName);
        stationRepository.addStation(start);
        stationRepository.addStation(end);
        return Line.of(name, start, end);
    }


}