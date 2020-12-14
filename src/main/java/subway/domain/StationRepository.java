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

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isExistedStation(String name) {
        for (Station station : stations) {
            if (isEqual(station, name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEqual(Station station, String name) {
        return station.isEqualName(name);
    }
}
