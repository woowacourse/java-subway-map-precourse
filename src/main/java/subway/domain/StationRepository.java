package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String WHITE_SPACE = " ";
    private static final int MINIMUM_NAME_LENGTH = 2;

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        validateNameContainWhitepace(name);
        validateNameDuplicate(name);
        validateNameLength(name);
        stations.add(new Station(name));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateNameContainWhitepace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 역 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private static void validateNameDuplicate(String name) {
        if (stations.stream()
            .anyMatch(station -> station.getName().equals(name))) {
            throw new IllegalArgumentException("동일한 지하철 역 이름이 존재합니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }
}
