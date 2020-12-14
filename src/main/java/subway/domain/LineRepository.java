package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final Map<Line, List<Station>> routes = new HashMap<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
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
    
    public static void addStationToRoutByName(String lineName, String stationName) {
        routes.get(getLineByName(lineName)).add(StationRepository.getStationByName(stationName));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    
    public static boolean containsName(String name) {
        return lines.stream().anyMatch(line -> line.nameEquals(name));
    }
}
