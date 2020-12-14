package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String STATION_NAME_LENGTH_ERROR = "지하철 역 이름이 2자 미만입니다.";
    private static final String STATION_NAME_DUPLICATE_ERROR = "기존의 역과 중복됩니다.";
    
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (!station.isValidName()) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR);
        }
        if (stations.contains(station)) {
            throw new IllegalArgumentException(STATION_NAME_DUPLICATE_ERROR);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
