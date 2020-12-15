package subway.domain;

import subway.exceptions.SubwayException;
import subway.exceptions.Validation;

import java.util.*;


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

    public static List<Station> getStations() {
        return stations;
    }

//    public static Station searchStationByName(String name) throws SubwayException {
//        Validation validation = new Validation();
//        return validation.isExistStation(name);
//    }
}
