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

    public int size() {
        return stations.size();
    }

    public void addStation(Station station, int sequence) {
        stations.add(sequence, station);
    }
}
