package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.exception.ShorterThanMinLineNameException;
import subway.line.exception.ShorterThanMinLineStationsSizeException;
import subway.station.domain.Station;

@DisplayName("지하철 노선(Line)에 대한 테스트")
class LineTest {

    final String LINE_NAME = "test line1";
    final Station upstreamStation = Station.from("test1");
    final Station downstreamStation = Station.from("test2");
    final int SIZE = 2;

    @DisplayName("지하철 노선 이름은 2글자 이상이어야 한다.")
    @Test
    void shorterThanMinLineNameException() {
        final String shortName = "a";

        assertThrows(ShorterThanMinLineNameException.class,
            () -> Line.of(shortName, upstreamStation, downstreamStation));
    }

    @DisplayName("지하철 노선을 생성할 수 있다.")
    @Test
    void create() {
        final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);

        assertNotNull(line);
    }

    @DisplayName("지하철 노선에 구간을 추가한다.")
    @Test
    void addSection() {
        final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);
        final Station station = Station.from("inserted station");
        final int indexToInsert = 1;
        line.addSection(indexToInsert, station);

        assertEquals(line.getStations().size(), SIZE + 1);
        assertSame(line.getStations().get(indexToInsert), station);
    }

    @DisplayName("지하철 노선에 등록된 역을 제거할 수 있다.")
    @Test
    void deleteSection() {
        final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);
        final Station station = Station.from("inserted station");
        final int indexToInsert = 1;
        line.addSection(indexToInsert, station);

        line.deleteSection(downstreamStation);

        assertFalse(line.getStations().contains(downstreamStation));
    }

    @DisplayName("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.")
    @Test
    void shorterThanMinLineStationsSizeException() {
        final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);

        assertThrows(ShorterThanMinLineStationsSizeException.class,
            () -> line.deleteSection(downstreamStation));
    }
}