package subway.domain;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static List<Station> getStations() {
        return stations;
    }

    public static Station searchStationByName(String name) {
        System.out.println(name);
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst().orElseThrow();
    }
}
