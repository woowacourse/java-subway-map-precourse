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

    public static void addLine(String lineName, String upboundStationName,
            String downboundStationName) {
        Line line = new Line(lineName);
        line.pushSections(upboundStationName, downboundStationName);
        lines.add(line);
    }

    public static void deleteLine(String name) {
        getLineByName(name).removeAllSections();
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAllLine() {
        lines.clear();
    }

    public static boolean hasLine(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).count() > 0;
    }

    public static boolean isEmpty() {
        return lines.isEmpty();
    }

    public static Line getLineByName(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).findFirst()
                .get();
    }
}
