package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final int FOR_ZERO_BASED_NUMBERING = 1;
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addSection(String lineName, Station station, int sequence) {
        Line line = selectLine(lineName);
        line.addSection(station, sequence - FOR_ZERO_BASED_NUMBERING);
    }

    public static boolean isIncludedSectionInLine(String lineName, String stationName) {
        Line line = selectLine(lineName);
        return line.isIncluded(stationName);
    }

    public static int countNumberOfStationsInLine(String lineName) {
        Line line = selectLine(lineName);
        return line.countSections();
    }

    public static void deleteSection(String lineName, String stationName) {
        Line line = selectLine(lineName);
        line.deleteSection(stationName);
    }

    private static Line selectLine(String name) {
        return lines.stream()
                .filter(line -> line.isMatchedName(name))
                .findAny()
                .get();
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isExistentName(String lineName) {
        return lines().stream()
                .anyMatch(line -> line.isMatchedName(lineName));
    }

    public static boolean isIncludedAnyLines(String stationName) {
        return lines().stream()
                .anyMatch(line -> line.isIncluded(stationName));
    }
}
