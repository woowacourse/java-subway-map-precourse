package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean deleteLineByName(String name) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                lines.remove(line);
                return true;
            }
        }
        throw new IllegalArgumentException();
    }
}
