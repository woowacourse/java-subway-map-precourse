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

    public static boolean isEmpty() {
        return stations.size() == 0;
    }

    public static boolean contains(String stationName) {
        return stations.stream().map(Station::getName).anyMatch(x -> x.equals(stationName));
    }

    public static Station getStationbyName(String stationName) {
        Station station = null;
        for (Station temp : stations) {
            if (temp.getName().equals((stationName))) {
                station = temp;
            }
        }
        return station;
    }
}
