package subway.domain.line;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.exception.CannotFindLineByNameException;
import subway.line.exception.DuplicateLineNameException;
import subway.station.domain.Station;

@DisplayName("지하철 노선 저장소(LineRepository)를 테스트 한다.")
class LineRepositoryTest {

    final String LINE_NAME = "test line";
    final int LINE_SIZE = 1;
    final Station upstreamStation = Station.from("test station1");
    final Station downstreamStation = Station.from("test station2");
    final int STATION_SIZE = 2;
    final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);

    @BeforeEach
    void before() {
        LineRepository.save(line);
    }

    @AfterEach
    void after() {
        LineRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 노선 이름은 등록될 수 없다.")
    @Test
    void duplicateLineNameException() {
        assertThrows(DuplicateLineNameException.class, () -> LineRepository.save(line));
    }

    @DisplayName("지하철 노선 저장소에 지하철 노선을 등록할 수 있다.")
    @Test
    void addLine() {
        final String NAME = "test";
        final Line line = Line.of(NAME, upstreamStation, downstreamStation);

        LineRepository.save(line);

        final int EXPECT = LINE_SIZE + 1;
        assertEquals(LineRepository.findAll().size(), EXPECT);
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선을 삭제할 수 있다.")
    @Test
    void deleteLine() {
        LineRepository.delete(line);

        final int EXPECT = LINE_SIZE - 1;
        assertEquals(LineRepository.findAll().size(), EXPECT);
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선의 목록을 조회할 수 있다.")
    @Test
    void findAllLine() {
        final List<Line> lines = LineRepository.findAll();

        assertEquals(lines.size(), LINE_SIZE);
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선에 구간을 추가할 수 있다.")
    @Test
    void insertSection() {
        final int indexToInsert = 1;
        final Station station = Station.from("inserted station");

        LineRepository.addSection(LINE_NAME, indexToInsert, station);

        Line findedLine = LineRepository.findByName(LINE_NAME);
        assertEquals(findedLine.getStations().size(), STATION_SIZE + 1);
        assertSame(findedLine.getStations().get(indexToInsert), station);
    }

    @DisplayName("지하철 노선 저장소에서 노선에 등록된 역을 제거할 수 있다.")
    @Test
    void deleteSection() {
        final int indexToInsert = 1;
        final Station station = Station.from("inserted station");
        LineRepository.addSection(LINE_NAME, indexToInsert, station);

        LineRepository.deleteSection(LINE_NAME, downstreamStation);

        Line findedLine = LineRepository.findByName(LINE_NAME);
        assertEquals(findedLine.getStations().size(), STATION_SIZE);
    }

    @DisplayName("등록되지 않은 지하철 노선은 조회할 수 없다.")
    @Test
    void cannotFindLineByNameException() {
        final String TARGET = "test";

        assertThrows(CannotFindLineByNameException.class, () -> LineRepository.findByName(TARGET));
    }

    @DisplayName("지하철 노선 저장소에 존재하는 지하철 노선을 이름으로 조회할 수 있다.")
    @Test
    void findLineByName() {
        final Line foundLine = LineRepository.findByName(LINE_NAME);

        assertSame(foundLine, line);
    }
}