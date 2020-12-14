package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException();
        }
        stations.add(station);
    }

    public static Station findStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean deleteStation(String name) {
        if (stations.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                stations.remove(station);
                return true;
            }
        }
        throw new IllegalArgumentException();
    }
}
