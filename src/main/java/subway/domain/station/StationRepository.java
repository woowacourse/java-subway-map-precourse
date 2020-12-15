package subway.domain.station;

import java.util.*;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean hasStation(Station station) {
        return stations.contains(station);
    }

    public static boolean deleteStation(StationName stationName) {
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
