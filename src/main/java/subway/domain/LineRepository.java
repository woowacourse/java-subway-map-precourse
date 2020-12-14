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

    public static boolean isEqualLineName(String name) {
        for (Line line : lines) {
            if (line.isEqualName(name)) {
                return true;
            }
        }
        return false;
    }

    public static Line getLine(String name) {
        for (Line line : lines) {
            if (line.isEqualName(name)) {
                return line;
            }
        }
        return null;
    }

    public static boolean isExistStation(String name) {
        for (Line line : lines) {
            if (line.isExistStation(name)) {
                return true;
            }
        }
        return false;
    }
}
