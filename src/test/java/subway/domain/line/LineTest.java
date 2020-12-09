package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.exception.ShorterThanMinLineNameException;
import subway.domain.station.Station;

@DisplayName("지하철 노선(Line)에 대한 테스트")
class LineTest {

    final Station upstreamStation = Station.from("test1");
    final Station downstreamStation = Station.from("test2");

    @DisplayName("지하철 노선 이름은 2글자 이상이어야 한다.")
    @Test
    void shorterThanMinLineNameException() {
        final String name = "a";

        assertThrows(ShorterThanMinLineNameException.class,
            () -> Line.of(name, upstreamStation, downstreamStation));
    }

    @DisplayName("지하철 노선을 생성할 수 있다.")
    @Test
    void create() {
        final String name = "test";
        final Line line = Line.of(name, upstreamStation, downstreamStation);

        assertNotNull(line);
    }
}