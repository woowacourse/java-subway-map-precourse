package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

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

    public static Line selectOneLineByName(String name) {
        for (Line line : lines) {
            if (name.equals(line.getName())) {
                return line;
            }
        }
        return null;
    }

    public static void addStationByIndex(int index, Line line, String stationName) {
        Line target = selectOneLineByName(line.getName());
        target.addRoute(index, stationName);
    }

    public static void deleteStationByName(Line line, String stationName) {
        Line target = selectOneLineByName(line.getName());
        target.deleteRoute(stationName);
    }

    public static int countStationNumInLine(Line line) {
        return line.getStationNumber();
    }

    public static boolean isDuplicateStationInLine(Line line, String stationName) {
        return line.isExistStationInLine(stationName);
    }

    public static boolean isExistName(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isLongName(String name) {
        String pattern = "^[0-9a-zA-Z가-힣]{2,}$";
        return Pattern.matches(pattern, name);
    }
}
