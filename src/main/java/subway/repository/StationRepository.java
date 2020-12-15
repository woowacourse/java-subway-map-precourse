package subway.repository;

import subway.domain.Constant;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    public static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStations(List<Station> stations){
        stations.forEach(StationRepository::addStation);
    }

    public static void addStation(Station station) {
        if (checkNameLength(station.getName())) {
            throw new IllegalStateException();
        }
        if (checkExistStation(station.getName())) {
            throw new IllegalArgumentException();
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean checkExistStation(String stationName) {
        return stations.stream().anyMatch(o -> o.getName().equals(stationName));
    }

    public static boolean checkNameLength(String name) {
        return name.length() <= Constant.MIN_LENGTH;
    }
}
