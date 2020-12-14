package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    public static int ROUTE_START = 1;
    public static int ROUTE_LENGTH_MIN = 2;
    
    private static final List<Line> lines = new ArrayList<>();
    private static final Map<Line, List<Station>> routes = new HashMap<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static List<String> lineNames() {
        return Collections.unmodifiableList(
                lines.stream().map(line -> line.getName()).collect(Collectors.toList()));
    }

    public static void addLine(Line line, List<String> endStationNames) {
        lines.add(line);
        routes.put(line, new ArrayList<>());
        for (String endStationName : endStationNames) {
            routes.get(line).add(StationRepository.getStationByName(endStationName));
        }
    }
    
    public static Line getLineByName(String lineName) {
        return lines.stream().filter(line -> line.nameEquals(lineName)).findAny().get();
    }
    
    public static int getRouteLengthByName(String lineName) {
        return routes.get(getLineByName(lineName)).size();
    }
    
    public static void addStationToRouteByName(String lineName, String stationName) {
        routes.get(getLineByName(lineName)).add(StationRepository.getStationByName(stationName));
    }
    
    public static void addStationToRouteByName(String lineName, String stationName, int index) {
        routes.get(getLineByName(lineName)).add(index, StationRepository.getStationByName(stationName));
    }

    public static void deleteStationFromRouteByName(String lineName, String stationName) {
        routes.get(getLineByName(lineName)).removeIf(station -> station.nameEquals(stationName));
    }

    public static boolean deleteLineByName(String name) {
        routes.remove(getLineByName(name));
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    
    public static boolean containsName(String name) {
        return lines.stream().anyMatch(line -> line.nameEquals(name));
    }

    public static boolean routeContainsByName(String lineName, String stationName) {
        return routes.get(getLineByName(lineName)).contains(StationRepository.getStationByName(stationName));
    }
}
