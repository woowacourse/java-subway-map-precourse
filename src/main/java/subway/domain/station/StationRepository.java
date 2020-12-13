package subway.domain.station;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static final String STATION_DUPLICATE_ERROR_MESSAGE = "[ERROR] 이미 등록된 역 이름입니다. 중복되지 않는 역이름을 입력해주세요.";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static List<Station> save(Station stationName) {
        if (stations.contains(stationName)) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR_MESSAGE);
        }
        stations.add(stationName);
        return stations;
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
