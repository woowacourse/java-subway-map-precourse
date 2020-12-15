package subway.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LineRepository {
    private static final Map<String, Line> lines = new LinkedHashMap<>();

    public static Map<String, Line> lines() {
        return Collections.unmodifiableMap(lines);
    }

    public static void addLine(Line line) {
        lines.put(line.getName(), line);
    }

    public static Line getLineByName(String name) {
        if (isExistLine(name)) {
            return lines.get(name);
        }
        return null;
    }

    public static boolean isStationInLines(Station station) {
        for (Line line : lines.values()) {
            if (line.sections().contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistLine(String name) {
        return lines.containsKey(name);
    }

    public static boolean deleteLineByName(String name) {
        return lines.remove(name) != null;
    }
}
