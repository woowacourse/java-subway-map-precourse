package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static Station selectStation(String name) {
        return stations.stream()
                .filter(station -> station.isMatchedName(name))
                .findAny()
                .get();
    }

    public static boolean isExistent(Station station) {
        return stations.contains(station);
    }

    public static boolean isExistentName(String name) {
        return stations.stream()
                .anyMatch(station -> station.isMatchedName(name));
    }
}
