package subway.line;

import org.junit.jupiter.api.Test;
import subway.station.Station;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    @Test
    void 노선에_등록된_역인지_확인_테스트() {
        // given, when
        LineRepository repository = new LineRepository();
        String onLineStation1 = "강남역";
        String onLineStation2 = "방배역";

        String notOnLineStation = "교대역";

        String lineName = "2호선";

        // when
        Line line = new Line(lineName, new Station(onLineStation1), new Station(onLineStation2));
        repository.addLine(line);

        // then
        assertTrue(repository.isStationOnLine(onLineStation1));
        assertFalse(repository.isStationOnLine(notOnLineStation));
    }

}