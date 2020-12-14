package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static List<String> stationNames() {
        return Collections.unmodifiableList(
                stations.stream().map(station -> station.getName()).collect(Collectors.toList()));
    }
    
    public static Station getStationByName(String stationName) {
        return stations.stream().filter(station -> station.nameEquals(stationName)).findAny().get();
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStationByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
    
    public static boolean containsName(String name) {
        return stations.stream().anyMatch(station -> station.nameEquals(name));
    }
}
