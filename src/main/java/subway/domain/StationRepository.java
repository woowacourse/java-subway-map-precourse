package subway.domain;

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
        Station thisStation = findStationByName(name);
        if (thisStation != null && thisStation.isRemovable()) {
            return stations.removeIf(station -> Objects.equals(station.getName(), name));
        }
        return false;
    }

    public static Station findStationByName(String name) {
        for (Station station : stations()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

}
