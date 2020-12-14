package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LineRepository {
    private static final Map<String, Line> lines = new HashMap<>();

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

    public static boolean isExistLine(String name) {
        return lines.containsKey(name);
    }

    public static boolean deleteLineByName(String name) {
        return lines.remove(name) != null;
    }
}
