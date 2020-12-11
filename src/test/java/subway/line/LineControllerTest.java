package subway.line;

import org.junit.jupiter.api.*;
import subway.domain.Line;
import subway.domain.Station;
import subway.station.StationRepository;
import subway.station.StationRepositoryJava;
import subway.station.StationResponseDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        String expectedMessage = "잘못된 역입니다. 역 정보를 먼저 등록 후 이용해주세요.";
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

    @Test
    @DisplayName("존재하지 않는 노선을 찾을 경우")
    public void findNonexistentLine() throws Exception {
        //given
        String expectedMessage = "등록되지 않은 노선입니다.";
        String nonexistentName = "11호선";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.findLineByName(nonexistentName));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("존재하는 노선을 찾을 경우")
    public void findExistentLine() throws Exception {
        //given
        String existentName = "1호선";
        //when
        LineResponseDTO lineByName = lineController.findLineByName(existentName);
        //then
        assertEquals(existentName, lineByName.getName());
    }

    @Test
    @DisplayName("존재하지 않는 역을 노선에 추가할 경우")
    public void addStationWithInvalidStation() throws Exception {
        //given
        String expectedMessage = "잘못된 역입니다. 역 정보를 먼저 등록 후 이용해주세요.";
        String lineName = "1호선";
        String stationName = "흥왕역";
        int index = 4;
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.addStationOnLine(stationName, lineName, index));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("존재하지 않는 노선에 역을 추가할 경우")
    public void addStationWithInvalidLine() throws Exception {
        //given
        String expectedMessage = "등록되지 않은 노선입니다.";
        String lineName = "11호선";
        String stationName = "의왕역";
        int index = 1;
        stationRepository.addStation(Station.from(stationName));
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.addStationOnLine(stationName, lineName, index));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("범위가 넘어간 순서를 지정했을 경우")
    public void addStationWithInvalidIndex() throws Exception {
        //given
        String expectedMessage = "순서가 너무 큽니다. 등록되어 있는 역 수 : 2";
        String lineName = "1호선";
        String stationName = "의왕역";
        int index = 4;
        stationRepository.addStation(Station.from(stationName));
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.addStationOnLine(stationName, lineName, index));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("모든 유효성을 통과한 역을 추가시")
    public void addStationWithValidInfo() throws Exception {
        //given
        int expectedSize = 3;
        String lineName = "1호선";
        String stationName = "의왕역";
        int index = 3;
        stationRepository.addStation(Station.from(stationName));
        //when
        lineController.addStationOnLine(stationName, lineName, index);
        //then
        LineResponseDTO lineByName = lineController.findLineByName(lineName);
        Optional<StationResponseDTO> findStation = lineByName.getStations()
                .stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny();
        assertEquals(expectedSize, lineByName.getStations().size());
        assertTrue(findStation.isPresent());
    }

    @Test
    @DisplayName("소지한 역이 두 개 이하인 노선의 역을 삭제 시 실패")
    public void removeStationFail() throws Exception {
        //given
        String expectedMessage = "노선을 유지하려면 최소 둘 이상의 역이 등록되어 있어야 합니다.";
        String lineName = "1호선";
        String stationName = "인천역";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.removeStationFromLine(stationName, lineName));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("소지하지 않는 역을 삭제 시도시")
    public void removeInvalidStation() throws Exception {
        //given
        String expectedMessage = "노선에 등록된 역이 아닙니다.";
        String lineName = "1호선";
        String stationName = "건대입구역";
        String addStationName = "잠실역";
        int index = 3;
        stationRepository.addStation(Station.from(addStationName));
        lineController.addStationOnLine(addStationName, lineName, index);
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.removeStationFromLine(stationName, lineName));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("소지하는 역 삭제 성공")
    public void removeStationSuccess() throws Exception{
        //given
        String lineName = "2호선";
        String addStationName = "잠실역";
        String removeStationName = "건대입구역";
        int index = 3;
        stationRepository.addStation(Station.from(addStationName));
        lineController.addStationOnLine(addStationName, lineName, index);
        //when
        lineController.removeStationFromLine(removeStationName, lineName);
        //then
        LineResponseDTO line = lineController.findLineByName(lineName);
        assertFalse(line.getStations().contains(removeStationName));
    }

    @Test
    @DisplayName("존재하지 않는 노선 삭제 시")
    public void removeNonexistentLine() throws Exception{
        //given
        String expectedMessage = "등록되지 않은 노선입니다.";
        String lineName = "11호선";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> lineController.removeLine(lineName));
        //then
        assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("노선 삭제 시 등록 되어 있는 역들의 노선 소지 여부도 줄어드는 지 확인")
    public void checkStationWhenRemovingLine() throws Exception{
        //given
        String lineName = "1호선";
        String stationName = "인천역";
        Station station = stationRepository.findStationByName(stationName).get();
        boolean before = station.isRemovable();
        //when
        lineController.removeLine(lineName);
        boolean after = station.isRemovable();
        //then
        assertFalse(before);
        assertTrue(after);
    }

    @Test
    @DisplayName("노선 삭제 성공")
    public void removeLineSuccess() throws Exception{
        //given
        String lineName = "1호선";
        //when
        lineController.removeLine(lineName);
        //then
        assertFalse(lineRepository.findByName(lineName).isPresent());
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