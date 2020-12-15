package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        stations.add(new Station(name));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAllStation() {
        stations.clear();
    }

    public static boolean hasStation(String name) {
        return stations.stream().filter(station -> Objects.equals(station.getName(), name))
                .count() > 0;
    }

    public static boolean isRemovable(String name) {
        return getByName(name).isRemovable();
    }

    public static boolean isEmpty() {
        return stations.isEmpty();
    }

    protected static Station getByName(String name) {
        return stations.stream().filter(station -> Objects.equals(station.getName(), name))
                .findFirst().get();
    }
}
