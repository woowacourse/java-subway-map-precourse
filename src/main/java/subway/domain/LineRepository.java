package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();
    private static final String[] initialLines = {"2호선", "3호선", "신분당선"};

    public LineRepository() {
        Arrays.stream(initialLines).forEach(line -> lines.add(new Line(line)));

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
