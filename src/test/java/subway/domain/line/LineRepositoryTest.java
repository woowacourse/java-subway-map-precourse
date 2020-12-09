package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.exception.CannotFindLineByNameException;
import subway.domain.line.exception.DuplicateLineNameException;
import subway.domain.station.Station;

@DisplayName("지하철 노선 저장소(LineRepository)를 테스트 한다.")
class LineRepositoryTest {

    final String STATION_NAME = "test station1";
    final Station upstreamStation = Station.from(STATION_NAME);
    final Station downstreamStation = Station.from("test station2");
    final Line line = Line.of(STATION_NAME, upstreamStation, downstreamStation);

    @BeforeEach
    void before() {
        LineRepository.addLine(line);
    }

    @AfterEach
    void after() {
        LineRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 노선 이름은 등록될 수 없다.")
    @Test
    void duplicateLineNameException() {
        assertThrows(DuplicateLineNameException.class, () -> LineRepository.addLine(line));
    }

    @DisplayName("지하철 노선 저장소에 지하철 노선을 등록할 수 있다.")
    @Test
    void addLine() {
        final String NAME = "test";
        final Line line = Line.of(NAME, upstreamStation, downstreamStation);

        LineRepository.addLine(line);

        final int EXPECT = 2;
        assertEquals(LineRepository.lines().size(), EXPECT);
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선을 삭제할 수 있다.")
    @Test
    void deleteLine() {
        LineRepository.deleteLineByName(STATION_NAME);

        final int EXPECT = 0;
        assertEquals(LineRepository.lines().size(), EXPECT);
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
        final Line foundLine = LineRepository.findByName(STATION_NAME);

        assertSame(foundLine, line);
    }
}