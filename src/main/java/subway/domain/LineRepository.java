package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        List<String> initialLines = new ArrayList<>(Arrays.asList(
                "2호선", "3호선", "신분당선"
        ));
        initialLines.stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
