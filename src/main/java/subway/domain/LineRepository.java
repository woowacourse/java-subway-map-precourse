package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.controller.LineMenu;
import subway.controller.exception.LineValidator;

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

    public static boolean isExistedLine(String name) {
        for (Line line : lines) {
            if (isEqual(line, name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEqual(Line line, String name) {
        return name.equals(line.getName());
    }
    
    public static boolean hasStation(String stationName) {
        for (Line line : lines) {
            if (line.isStation(stationName)) {
                return true;
            }
        }
        return false;
    }
}
