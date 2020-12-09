package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.exception.DuplicateLineNameException;
import subway.domain.station.Station;

@DisplayName("지하철 노선 저장소(LineRepository)를 테스트 한다.")
class LineRepositoryTest {

    final Station upstreamStation = Station.from("test1");
    final Station downstreamStation = Station.from("test2");

    @AfterEach
    void after() {
        LineRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 노선 이름은 등록될 수 없다.")
    @Test
    void duplicateLineNameException() {
        final String NAME = "test";
        final Line line = Line.of(NAME, upstreamStation, downstreamStation);
        LineRepository.addLine(line);

        assertThrows(DuplicateLineNameException.class, () -> {
            final Line newLine = Line.of(NAME, upstreamStation, downstreamStation);
            LineRepository.addLine(newLine);
        });
    }

    @DisplayName("지하철 노선 저장소에 지하철 노선을 등록할 수 있다.")
    @Test
    void addLine() {
        final String NAME = "test";
        final Line line = Line.of(NAME, upstreamStation, downstreamStation);

        LineRepository.addLine(line);

        final int EXPECT = 1;
        assertEquals(LineRepository.lines().size(), EXPECT);
    }
}