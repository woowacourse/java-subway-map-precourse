package subway.domain;

import java.util.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_ERROR = "[ERROR] 이미 등록되어 있는 역입니다.";
    private static final String STATION_EXIST_ERROR = "[ERROR] 등록되어 있는 역이 아닙니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    private static void validateDuplicate(Station station) {
        Set<Station> duplicateCheckSet = new HashSet<>(stations);
        duplicateCheckSet.add(station);
        if (duplicateCheckSet.size() == stations.size()) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteStation(String name) {
        validateNameExist(new Station(name));
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void validateNameExist(Station newStation) {
        boolean nameFlag = true;
        for (Station station : stations) {
            if (station.equals(newStation)) {
                nameFlag = false;
                break;
            }
        }
        if (nameFlag) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR);
        }
    }

}
