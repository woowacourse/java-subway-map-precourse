package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    public static final String ERROR_SAME_NAME = "같은 이름의 노선이 존재합니다.";
    public static final String ERROR_NO_MATCH_NAME = "해당 이름의 노선이 존재하지 않습니다.";
    public static final String ERROR_USED_STATION = "해당 이름의 역이 노선에 등록되어 있습니다.";
    public static final boolean USED = true;
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        validateNameExistence(name);
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLine(String lineName) {
        return lines().stream()
                .filter(line -> line.getName().equals(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_MATCH_NAME));
    }

    public static void checkDuplication(String name) {
        boolean isAnyMatch = lines().stream()
                .anyMatch(line -> line.getName().equals(name));

        if (isAnyMatch) {
            throw new IllegalArgumentException(ERROR_SAME_NAME);
        }
    }

    public static void checkStationUsedInLines(Station station) {
        List<Boolean> isStationUsed = lines().stream()
                .map(Line::getStations)
                .map(stations -> validateStationUsed(stations, station))
                .collect(Collectors.toList());

        if (isStationUsed.stream()
                .anyMatch(isUsed -> Objects.equals(isUsed, USED))) {
            throw new IllegalArgumentException(ERROR_USED_STATION);
        }
    }

    private static boolean validateStationUsed(List<Station> stations, Station stationToFind) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationToFind.getName()));
    }

    private static void validateNameExistence(String lineName) {
        boolean isAnyMatch = lines().stream()
                .anyMatch(line -> line.getName().equals(lineName));

        if (!isAnyMatch) {
            throw new IllegalArgumentException(ERROR_NO_MATCH_NAME);
        }
    }
}
