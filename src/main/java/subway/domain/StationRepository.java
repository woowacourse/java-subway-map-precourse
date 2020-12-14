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

    public static void printStationList() {
        if (stations.size() == 0) {
            System.out.println("존재하는 역이 없습니다.");
            return;
        }
        for (Station station : stations) {
            System.out.println(station.getName());
        }
    }

}
