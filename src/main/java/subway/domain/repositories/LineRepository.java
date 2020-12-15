package subway.domain.repositories;

import subway.domain.Line;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static Map<String, List<String>> lineMap = new HashMap<>();

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

    public static List<String> getUsingStations() {
        List<String> usingStations = new ArrayList<>();
        for (List<String> list : lineMap.values()) {
            usingStations.addAll(list);
        }
        return Collections.unmodifiableList(usingStations);
    }

    public static void deleteLineMapByName(String name) {
        lineMap.remove(name);
    }

    public static boolean deleteStationInLine(String lineName, String stationName) {
        List<String> list = new ArrayList<>(lineMap.get(lineName));
        if (list.size() <= 2) {
            return false;
        }
        list.remove(stationName);
        lineMap.put(lineName, list);
        return true;
    }

    public static List<String> getStationsByLineName(String lineName) {
        List<String> lineContainStations = new ArrayList<>(lineMap.get(lineName));
        return Collections.unmodifiableList(lineContainStations);
    }

    public static int getLineSize(String lineName) {
        List<String> lineContainStations = new ArrayList<>(lineMap.get(lineName));
        return lineContainStations.size();
    }
}
