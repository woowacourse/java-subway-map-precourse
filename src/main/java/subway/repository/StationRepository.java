package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Station;

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

    public static boolean isDuplicateStation(Station station) {
        return stations.contains(station);
    }

    public static Station findByName(String name) {
        return stations.stream().filter(station ->station.getName().equals(name)).findFirst().get();
    }

    public static void setStationIsRegistered(String name) {
        findByName(name).setRegistered(true);
    }

    public static void setAllStationIsRegistered(List<Station> stationList) {
        for(Station station : stationList) {
            findByName(station.getName()).setRegistered(true);
        }
    }

    public static void setStationIsUnregistered(String name) {
        findByName(name).setRegistered(false);
    }
}
