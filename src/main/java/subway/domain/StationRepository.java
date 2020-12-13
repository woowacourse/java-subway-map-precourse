package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.Validator;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        Validator.checkDeletableStation(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean hasStation(String stationName) {
        return stations().stream()
            .anyMatch(station -> station.getName().equals(stationName));
    }

    public static ArrayList<Station> getAllStations() {
        return (ArrayList<Station>) stations;
    }

    public static Station getStation(String stationName) throws NullPointerException {
        return stations().stream()
            .filter(station -> station.getName().equals(stationName))
            .findFirst()
            .orElse(null);
    }

    public static void setStations(ArrayList<Station> stations) {
        stations.forEach(StationRepository::addStation);
    }
}
