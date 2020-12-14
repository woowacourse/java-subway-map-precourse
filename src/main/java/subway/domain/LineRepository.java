package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkOverlappedLine(line.getName());
        lines.add(line);
        Collections.sort(lines);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void checkOverlappedLine(String target) {
        long isOverlap = lines.stream()
                .filter(line -> line.compareName(target))
                .count();
        if (isOverlap != DomainConstant.ZERO_LONG_NUMBER) {
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_LINE_ERROR);
        }
    }

    public static void insertStationToLine(String lineTitle, String stationTitle, int order) {
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach(line -> line.insertStation(order, new Station(stationTitle)));
    }

    public static void deleteStationToLine(String lineTitle, String stationTitle) {
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach((line -> line.deleteStation(stationTitle)));
    }
}
