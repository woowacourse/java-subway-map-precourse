package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stations {
    private final List<Station> stations;

    private Stations(List<Station> stations) {
        this.stations = new ArrayList<>(stations);
    }

    public static Stations of(List<Station> stations) {
        return new Stations(stations);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
