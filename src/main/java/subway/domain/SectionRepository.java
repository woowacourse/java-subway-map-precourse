package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<Station>> section = new HashMap<>();
    private static final Set<String> stations = new HashSet<>();

    public static Map<String, List<Station>> sections() {
        return Collections.unmodifiableMap(section);
    }

    public static void addSection(String lineName, String stationName, int order) {
        section.computeIfAbsent(lineName, k -> new ArrayList<>());
        section.get(lineName).add(order, new Station(stationName));
        stations.add(stationName);
    }

    public static boolean deleteSectionByName(String lineName, String stationName) {
        boolean result = section.get(lineName).removeIf(station -> Objects.equals(station.getName(), stationName));
        if(result) {
            stations.remove(stationName);
        }
        return result;
    }

    public static boolean checkStationInLine(String stationName) {
        if(stations.contains(stationName)) {
            return true;
        }
        return false;
    }
}
