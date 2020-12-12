package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    private static final Set<String> lineNames = new HashSet<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
        lineNames.add(line.getName());
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Set<String> lineNames() {
        return Collections.unmodifiableSet(lineNames);
    }

    public static Line findLine(String name) {
        return lines.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst()
            .get();
    }
}
