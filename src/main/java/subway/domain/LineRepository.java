package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static List<String> lineNames() {
        return Collections.unmodifiableList(
                lines.stream().map(line -> line.getName()).collect(Collectors.toList()));
    }

    public static void addLine(Line line, List<String> endStationNames) {
        lines.add(line);
        for (String endStationName : endStationNames) {
            line.addStationToRoute(StationRepository.getStationByName(endStationName));
        }
    }
    
    public static Line getLineByName(String lineName) {
        return lines.stream().filter(line -> line.nameEquals(lineName)).findAny().get();
    }
    
    public static int getRouteLengthByName(String lineName) {
        return getLineByName(lineName).routeLength();
    }
    
    public static void addStationToRouteByName(String lineName, String stationName) {
       getLineByName(lineName).addStationToRoute(StationRepository.getStationByName(stationName));
    }
    
    public static void addStationToRouteByName(String lineName, String stationName, int index) {
        getLineByName(lineName).addStationToRoute(index, StationRepository.getStationByName(stationName));
    }

    public static void deleteStationFromRouteByName(String lineName, String stationName) {
        getLineByName(lineName).removeStationFromRoute(StationRepository.getStationByName(stationName));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    
    public static boolean containsName(String name) {
        return lines.stream().anyMatch(line -> line.nameEquals(name));
    }

    public static boolean routeContainsByName(String lineName, String stationName) {
        return getLineByName(lineName).containsStationInRoute(StationRepository.getStationByName(stationName));
    }

    public static boolean anyRouteContainsByStationName(String stationName) {
        for (Line line : lines) {
            if (line.containsStationInRoute(StationRepository.getStationByName(stationName))) {
                return true;
            }
        }
        return false;
    }
    
    static void addLine(Line line) {
        lines.add(line);
    }
    
    static void clear() {
        lines.clear();
    }
}
