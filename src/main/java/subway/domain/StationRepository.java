package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    private final Set<Station> stations = new HashSet<>();

    public void addStation(Station station) {
        stations.add(station);
    }

    public Set<Station> findAll() {
        return Collections.unmodifiableSet(stations);
    }

    public Station findByName(String name) {
        return stations.stream()
            .filter(station -> station.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public boolean isExistByName(String name) {
        return findByName(name) != null;
    }

    public boolean deleteStationByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
