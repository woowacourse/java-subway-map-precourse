package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    private final Set<Station> stations;

    public StationRepository() {
        this.stations = new LinkedHashSet<>();
    }

    public Set<Station> stations() {
        return Collections.unmodifiableSet(stations);
    }

    public boolean addStation(Station station) {
        return stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
