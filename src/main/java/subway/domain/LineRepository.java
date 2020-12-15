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

    private static final int FROM_ORDER_TO_INDEX = 1;

    public static Line getLine(String name) {
        return lines.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .get();
    }

    public static Line getNewLine() {
        return lines.get(lines.size() - FROM_ORDER_TO_INDEX);
    }

    public static void deleteStationInLine(String name) {
        for (Line line : lines) {
            line.getSections().removeIf(station -> Objects.equals(station.getName(), name));
        }
    }

    public static boolean isDuplicate(String name) {
        return lines.stream()
                .anyMatch(station -> station.getName().equals(name));
    }

    public static List<Line> getLines() {
        return lines;
    }
}
