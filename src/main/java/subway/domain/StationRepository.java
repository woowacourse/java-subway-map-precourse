package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    public static final String ERROR_SAME_NAME = "같은 이름의 역이 존재합니다.";
    public static final String ERROR_NO_MATCH_NAME = "해당 이름의 역이 존재하지 않습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplication(station.getName());
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        validateNameExistence(name);
        validateInLine(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStation(String name) {
        return stations().stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_MATCH_NAME));
    }

    private static void validateDuplication(String name) {
        boolean isAnyMatch = stations().stream()
                .anyMatch(station -> station.getName().equals(name));

        if (isAnyMatch) {
            throw new IllegalArgumentException(ERROR_SAME_NAME);
        }
    }

    private static void validateNameExistence(String name) {
        boolean isAnyMatch = stations().stream()
                .anyMatch(station -> station.getName().equals(name));

        if (!isAnyMatch) {
            throw new IllegalArgumentException(ERROR_NO_MATCH_NAME);
        }
    }

    private static void validateInLine(String name) {
        LineRepository.checkStationUsedInLines(findStation(name));
    }
}

