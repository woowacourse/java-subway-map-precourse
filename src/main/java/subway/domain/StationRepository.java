package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    private static final Set<Station> stations = new HashSet<>();

    public void addStation(Station station) {
        stations.add(station);
    }

    public static Set<Station> findAll() {
        return Collections.unmodifiableSet(stations);
    }

    public Station findByName(String station) {
        for (Station stationElement : stations) {
            if (stationElement.getName().equals(station)) {
                return stationElement;
            }
        }
        return null;
    }

    public boolean deleteStationByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
