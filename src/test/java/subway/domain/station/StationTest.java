package subway.domain.station;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.station.domain.Station;
import subway.station.exception.ShorterThanMinStationNameException;

@DisplayName("지하철 역(Station)에 대한 테스트")
class StationTest {

    @DisplayName("지하철 역 이름은 2글자 이상이어야 한다.")
    @Test
    void shorterThanMinStationNameException() {
        final String name = "a";

        assertThrows(ShorterThanMinStationNameException.class, () -> Station.from(name));
    }

    @DisplayName("지하철 역을 생성할 수 있다.")
    @Test
    void create() {
        final String name = "test";
        final Station station = Station.from(name);

        assertNotNull(station);
    }
}