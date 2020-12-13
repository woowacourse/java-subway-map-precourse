package subway.line;

import org.junit.jupiter.api.Test;
import subway.station.Station;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    @Test
    void 노선에_등록된_역인지_확인_테스트() {
        // given, when
        String stationName = "강남역";
        String stationName2 = "교대역";
        String lineName = "2호선";

        // when
        Line line = new Line(lineName);
        line.addStation(new Station(stationName));
        LineRepository.addLine(line);

        // then
        assertThrows(Exception.class, () -> {
            LineService.getInstance().checkStationOnAnySubwayLine(stationName);
        });
        assertDoesNotThrow(() -> {
            LineService.getInstance().checkStationOnAnySubwayLine(stationName2);
        });
    }

}