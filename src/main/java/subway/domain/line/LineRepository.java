package subway.domain.line;

import java.util.*;
import java.util.stream.Stream;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }


    public static boolean hasLine(LineName lineName) {
        return lines.stream()
                .map(Line::getName)
                .anyMatch(name -> name.equals(lineName));
    }

    public static boolean deleteLineByName(LineName lineName) {
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }
}
