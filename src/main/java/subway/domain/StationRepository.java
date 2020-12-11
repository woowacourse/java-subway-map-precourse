package subway.domain;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean contains(String name) {
        return stations().stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        return stations().stream().filter(station -> Objects.equals(station.getName(), name)).findAny().orElse(null);
    }
}
