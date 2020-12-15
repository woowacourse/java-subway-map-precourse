package subway.domain;

import subway.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String stationName) {
        if (checkNameLength(stationName)){
            throw new IllegalStateException();
        }
        if(checkExistStation(stationName)) {
            throw new IllegalArgumentException();
        }
        stations.add(new Station(stationName));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void printStations() {
        for (int i = 0; i < stations.size(); i++) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, stations.get(i).getName()));
        }
    }

    public static boolean checkExistStation(String stationName) {
        return stations.stream().anyMatch(o -> o.getName().equals(stationName));
    }

    public static boolean checkNameLength(String name) {
        return name.length() <= Constant.MIN_NAME_LENGTH;
    }
}
