package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StationTest {

    private static final String stationName1 = "강남역";
    private static final String stationName2 = "역삼역";
    private final String validStationName = "매봉역";
    private final String invalidStationName = "a";
    private static final String lineName = "2호선";
    private static final Station station1 = new Station(stationName1);
    private static final Station station2 = new Station(stationName2);
    private static Line line;

    @BeforeAll
    static void init() {
        final List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        line = new Line(lineName, stations);
    }

    @Test
    void station_ValidName_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() -> {
            Station station = new Station(validStationName);
        });
    }

    @Test
    void station_InvalidName_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Station station = new Station(invalidStationName);
        });
    }

    @Test
    void getName_SameName_Equal() {
        assertThat(station1.getName()).isEqualTo(stationName1);
    }

    @Test
    void getName_DifferentName_NotEqual() {
        assertThat(station1.getName()).isNotEqualTo(stationName2);
    }

    @Test
    void hasParentLine_ValidUsage_True() {
        final Station station = new Station(validStationName);
        station.addParentLine(line);
        assertThat(station.hasParentLine()).isTrue();
        station.removeParentLine(line);
        assertThat(station.hasParentLine()).isFalse();
    }
}
