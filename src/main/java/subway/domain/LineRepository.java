package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LineRepository {
    private static final Set<Line> lines = new LinkedHashSet<>();

    public static Set<Line> lines() {
        return Collections.unmodifiableSet(lines);
    }

    public static boolean addLine(Line line) {
        return lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
