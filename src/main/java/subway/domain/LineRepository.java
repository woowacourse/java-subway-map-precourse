package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.exception.DuplicatedLineNameException;
import subway.exception.NullLineException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (containsLine(line)) {
            throw new DuplicatedLineNameException(line.getName());
        }

        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        if (!containsLine(name)) {
            throw new NullLineException(name);
        }

        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLine(String name) {
        Line matchedLine = lines.stream()
                .filter(streamLine -> name.equals(streamLine.getName()))
                .findAny().orElse(null);
        if (matchedLine == null) {
            throw new NullLineException(name);
        }

        return matchedLine;
    }

    public static boolean containsLine(Line line) {
        return containsLine(line.getName());
    }

    public static boolean containsLine(String name) {
        return lines.stream().anyMatch(streamLine -> name.equals(streamLine.getName()));
    }

    public static boolean anyLineContainsStation(String stationName) {
        for (Line line : lines) {
            if (line.containsStation(stationName)) {
                return true;
            }
        }

        return false;
    }
}
