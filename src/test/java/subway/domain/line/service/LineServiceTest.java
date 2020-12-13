package subway.domain.line.service;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineServiceTest {

    @BeforeAll
    static void beforeAll() {
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("잠실역"));
    }

    @AfterEach
    void tearDown() {
        LineRepository.deleteAll();
    }

    @AfterAll
    static void afterAll() {
        StationRepository.deleteAll();
    }

    @DisplayName("지하철 노선의 목록을 조회하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1호선,2호선,3호선:3", "신분당선,분당선,경의선,공항철도:4"
            }, delimiter = ':'
    )
    void testFindAll(String input, int lineNumber) {
        //given
        String[] lineNames = input.split(",");
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());

        Arrays.stream(lineNames)
                .map(name -> new Line(name, stations))
                .forEach(LineRepository::addLine);

        //when
        List<Line> lines = LineService.findAll();

        //then
        List<Line> expectedLines = Arrays.stream(lineNames)
                .map(name -> new Line(name, stations))
                .collect(Collectors.toList());
        assertAll(
                () -> assertThat(lines)
                        .usingElementComparatorOnFields("name")
                        .containsAll(expectedLines),
                () -> assertThat(lines).hasSize(lineNumber)
        );
    }

    @DisplayName("지하철 노선을 등록하는 기능을 테스트한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "경의선", "신분당선", "1호선", "2호선"
    })
    void testSave(String lineName) {
        //when
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(lineName, stations);

        //when
        LineService.save(line);

        //then
        List<Line> lines = LineRepository.lines();
        assertAll(
                () -> assertThat(lines).hasSize(1),
                () -> assertThat(lines).usingElementComparatorOnFields("name")
                        .contains(line)
        );
    }

    @DisplayName("노선 이름이 중복되면 예외를 발생시키는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1호선,2호선:1호선",
            "신분당선,경의선,분당선:경의선"
    }, delimiter = ':')
    void testSaveIfDuplicatedLineName(String input, String newLineName) {
        //given
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());

        String[] lineNames = input.split(",");
        Arrays.stream(lineNames)
                .map(name -> new Line(name, stations))
                .forEach(LineRepository::addLine);

        //when //then
        assertThatThrownBy(() -> LineService.save(new Line(newLineName, stations)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지하철 노선을 삭제하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1호선,2호선:1호선:1",
            "신분당선,경의선,분당선:경의선:2"
    }, delimiter = ':')
    void testRemove(String input, String removedLineName, int expectedLinesNumber) {
        //given
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());

        String[] lineNames = input.split(",");
        Arrays.stream(lineNames)
                .map(name -> new Line(name, stations))
                .forEach(LineRepository::addLine);
        Line removedLine = new Line(removedLineName, stations);

        //when
        LineService.remove(removedLine);

        //then
        List<Line> lines = LineRepository.lines();

        assertAll(
                () -> assertThat(lines).hasSize(expectedLinesNumber),
                () -> assertThat(lines).usingElementComparatorOnFields("name")
                        .doesNotContain(new Line(removedLineName, stations))
        );
    }

    @DisplayName("상행, 하행 종점역이 등록되지 않은 역인 경우 예외를 던지는 기능을 테스트한다")
    @Test
    void testInitLineIfStationsAreNotFound() {
        //given
        String stationNames = "강남역,봉천역";
        String lineName = "2호선";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line savedLine = new Line(lineName, stations);

        //when //then
        assertThatThrownBy(() -> LineService.save(savedLine))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지하철 노선에 구간을 추가하는 기능을 테스트한다")
    @Test
    public void testAddStation() {
        //when
        String lineName = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(lineName, stations);
        LineService.save(line);

        Station newStation = new Station("사당역");
        StationRepository.addStation(newStation);
        int newStationLocation = 1;

        //when
        LineService.addStation(lineName, newStation, newStationLocation);

        //then
        List<Line> lines = LineRepository.lines();
        assertAll(
                () -> assertThat(lines).hasSize(1),
                () -> assertThat(lines.get(0).getStations()).hasSize(3),
                () -> assertThat(lines.get(0).getStations())
                        .usingElementComparatorOnFields("name")
                        .contains(newStation, Index.atIndex(newStationLocation))
        );
    }
}
