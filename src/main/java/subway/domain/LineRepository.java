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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLineNamed(String name) {
        Line lineLookingFor = null;
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                lineLookingFor = line;
                break;
            }
        }
        return lineLookingFor;
    }

    public static boolean isEmpty() {
        return lines.isEmpty();
    }

}
