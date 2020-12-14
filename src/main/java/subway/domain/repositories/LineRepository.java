package subway.domain.repositories;

import subway.domain.Line;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static HashMap<String, List<String>> lineMap = new HashMap<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addStationToLine(String lineName, String frontStation, String backStation) {
        lineMap.put(lineName, Arrays.asList(frontStation, backStation));
    }

    public static void addStationToLine(String lineName, String stationName, int location) {
        List<String> list = new ArrayList<>(lineMap.get(lineName));
        list.add(location - 1, stationName);
        lineMap.put(lineName, list);
    }
}
