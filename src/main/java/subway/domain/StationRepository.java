package subway.domain;

import java.util.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_ERROR = "[ERROR] 이미 등록되어 있는 역입니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateDuplicate(Station station) {
        Set<Station> duplicateCheckSet = new HashSet(stations());
        duplicateCheckSet.add(station);
        if (duplicateCheckSet.size() == stations.size()) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }
}
