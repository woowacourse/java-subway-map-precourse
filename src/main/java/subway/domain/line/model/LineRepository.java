package subway.domain.line.model;

import java.util.*;

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

    public static void deleteAll() {
        lines.clear();
    }

    public static Optional<Line> findLineByName(String lineName) {
        return LineRepository.lines().stream()
                .filter(line -> line.isEqualTo(lineName))
                .findAny();
    }
}
