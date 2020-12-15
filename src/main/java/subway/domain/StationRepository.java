package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final String ERR_STATION_NOT_IN_REPO = "존재하지 않는 역 이름입니다";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(Station station) {
        return stations.remove(station);
    }

    public static Station getStation(String name) {
        return stations().stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_STATION_NOT_IN_REPO));
    }

    public static boolean hasStationNamed(String name) {
        return stations().stream()
                .anyMatch(station -> station.getName().equals(name));
    }
}
