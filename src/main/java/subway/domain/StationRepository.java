package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final int ZERO_NUMBER = 0;
    private static final String OVERLAP_ERROR = "[ERROR] 역의 이름이 중복이 되었습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        checkOverlappedStation(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void checkOverlappedStation(Station target) {
        long isOverlap = stations.stream()
                .filter(station -> station.compareName(target.getName()))
                .count();
        if (isOverlap != ZERO_NUMBER) {
            throw new IllegalArgumentException(OVERLAP_ERROR);
        }
    }
}
