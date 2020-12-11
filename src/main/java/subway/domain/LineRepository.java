package subway.domain;

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

    public static boolean contains(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLineByName(String name) {
        Optional<Line> result = lines.stream()
                .filter(line -> Objects.equals(line.getName(), name)).findAny();

        if(result.isEmpty()) {
            return null;
        }
        return result.get();
    }
}
