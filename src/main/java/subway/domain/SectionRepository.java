package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<Station>> section = new HashMap<>();

    public static Map<String, List<Station>> sections() {
        return Collections.unmodifiableMap(section);
    }

    public static void addSection(String lineName, String stationName, int order) {
        section.computeIfAbsent(lineName, k -> new ArrayList<>());
        section.get(lineName).add(order, new Station(stationName));
    }

    public static boolean deleteSectionByName(String lineName, String stationName) {
        return section.get(lineName).removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
