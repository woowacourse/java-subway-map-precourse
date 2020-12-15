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

    public static boolean findByName(String name) {
        return lines().stream().anyMatch(line -> line.getName().equals(name));
    }

    public static Line findLineByName(String name) {
        return lines.stream().filter(line ->
                line.getName().equals(name)).findAny().orElse(null);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
