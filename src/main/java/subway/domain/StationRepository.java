package subway.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StationRepository {
    private static final Map<String, Station> stations = new LinkedHashMap<>();

    public static Map<String, Station> stations() {
        return Collections.unmodifiableMap(stations);
    }

    public static void addStation(Station station) {
        stations.put(station.getName(), station);
    }

    public static Station getStationByName(String name) {
        if (isExistStation(name)) {
            return stations.get(name);
        }
        return null;
    }

    public static boolean isExistStation(String name) {
        return stations.containsKey(name);
    }

    public static boolean deleteStation(String name) {
        return stations.remove(name) != null;
    }
}
