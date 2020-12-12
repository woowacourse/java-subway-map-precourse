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

    public static void addLine(String lineName, String upboundStationName, String downboundStationName) {
        lines.add(new Line(lineName, upboundStationName, downboundStationName));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasLine(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).count() > 0;
    }
}
