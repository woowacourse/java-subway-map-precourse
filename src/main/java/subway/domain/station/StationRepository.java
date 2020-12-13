package subway.domain.station;

import java.util.*;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(StationName stationName) {
        stations.add(Station.of(stationName));
    }

    public static boolean hasStation(StationName stationName) {
        return stations.contains(Station.of(stationName));
    }

    public static boolean deleteStation(StationName stationName) {
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
