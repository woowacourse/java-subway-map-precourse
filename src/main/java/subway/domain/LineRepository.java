package subway.domain;

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
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean contains(String stationName) {
        return lines.stream().map(Line::getName).anyMatch(x -> x.equals(stationName));
    }

    public static boolean isEmpty() {
        return lines.size() == 0;
    }

    public static boolean containsLineWithStationName(String lineName, String stationName) {
        Line line = getLineByName(lineName);
        return line.contains(stationName);
    }

    public static Line getLineByName(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName)).findAny().orElse(null);
    }

    public static boolean containsLineForIndex(String lineName, int index) {
        Line line = getLineByName(lineName);
        return line.size() >= index;
    }

    public static void addStationNameToLine(String lineName, String stationName, int index) {
        Line line = getLineByName(lineName);
        line.addStationName(index, stationName);
    }

    public static boolean containsLineAboveDeleteLimit(String lineName, int deleteLimit) {
        Line line = getLineByName(lineName);
        return line.size() > deleteLimit;
    }

    public static void deleteStationNameFromLine(String lineName, String stationName) {
        Line line = getLineByName(lineName);
        line.deleteStationName(stationName);
    }
}
