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

    public static void addStation(Station station, int index) {
        stations.add(index-1, station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        for (Station station : stations()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public static void printStationList() {
        if (stations.size() == 0) {
            System.out.println("존재하는 역이 없습니다.\n");
            return;
        }
        for (Station station : stations) {
            System.out.println("[ INFO ] " + station.getName());
        }
        System.out.println();
    }

}
