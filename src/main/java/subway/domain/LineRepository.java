package subway.domain;

import exception.NoExistLineNameException;

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

    public static void deleteLineInStation(String lineName) {
        getLine(lineName).deleteLineNameInStation(lineName);
    }

    public static Line getLine(String name) {
        for (Line line : lines()) {
            if (line.getName().equals(name))
                return line;
        }
        throw new NoExistLineNameException();
    }

    public static boolean isLine(String name) {
        for (Line line : lines()) {
            if (line.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
