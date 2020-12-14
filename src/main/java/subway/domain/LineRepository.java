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

    private static boolean isEqual(Line line, String name) {
        return line.isEqualName(name);
    }

    public static boolean isExistedLine(String name) {
        for (Line line : lines) {
            if (isEqual(line, name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasStation(String stationName) {
        for (Line line : lines) {
            if (line.isStation(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSection(String lineName, String stationName) {
        for (Line line : lines) {
            if (isEqual(line, lineName)) {
                return isLineAlreadyHasTheStation(line, stationName);
            }
        }
        return false;
    }

    private static boolean isLineAlreadyHasTheStation(Line line, String stationName) {
        if (line.isStation(stationName)) {
            return true;
        }
        return false;
    }

    public static boolean isBiggerLineSizeThan(String lineName, int number) {
        for (Line line : lines) {
            if (isEqual(line, lineName)) {
                return line.isBiggerThan(number);
            }
        }
        return false;
    }

    public static void addSectionToLine(String lineName, String stationName, String order) {
        for (Line line : lines) {
            if (isEqual(line, lineName)) {
                line.addSection(stationName, order);
            }
        }
    }

    public static void deleteSectionFromLine(String lineName, String stationName) {
        for (Line line : lines) {
            if (isEqual(line, lineName)) {
                line.deleteSection(stationName);
            }
        }
    }
}
