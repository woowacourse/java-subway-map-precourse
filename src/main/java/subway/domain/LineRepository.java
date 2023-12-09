package subway.domain;

import static subway.exception.ExceptionMessage.NOT_FOUND_LINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static void initialize() {
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));
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

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_LINE.getMessage()));
    }

    public static boolean containsLineName(String lineName) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(lineName));
    }
}
