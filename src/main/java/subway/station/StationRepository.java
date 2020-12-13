package subway.station;

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

    public static void checkDuplicateStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
            }
        }
    }

    public static void checkStationExist(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 역입니다.");
    }
}
