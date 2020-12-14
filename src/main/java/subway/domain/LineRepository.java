package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final HashMap<Line, List<String>> lineMap = new HashMap<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addStationToLine(Line line, String frontStation, String backStation) {
        lineMap.put(line, Arrays.asList(frontStation, backStation));
    }
}
