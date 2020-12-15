package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static Line findLineByName(String name) {
        for (Line line : lines()) {
            if (line.isSameNameThan(name)) {
                return line;
            }
        }
        return null;
    }

    public static List<String> getLinesWithFormatting(){
        return lines().stream().map(Line::formatName).collect(Collectors.toList());
    }
}
