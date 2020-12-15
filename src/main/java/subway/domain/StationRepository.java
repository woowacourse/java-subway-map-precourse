package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String INFO = "[INFO] ";
    private static final String STATION_LIST = "## 역 목록";

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

    public static boolean isStationExist(String upwardTerminalStation) {
        for (Station station : stations) {
            if (station.isSameName(upwardTerminalStation)) {
                return true;
            }
        }
        return false;
    }

    public static void printStations() {
        System.out.println();
        System.out.println(STATION_LIST);
        for (Station station : stations) {
            System.out.println(INFO + station.getName());
        }
    }
}
