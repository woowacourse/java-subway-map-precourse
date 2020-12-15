package subway.domain.section;

import subway.domain.station.Station;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<Station>> sections = new HashMap<>();
    private static final Set<String> usedStations = new HashSet<>();

    public static Map<String, List<Station>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(Section section) {
        int orderNum = section.getOrder() - 1;
        sections.computeIfAbsent(section.getLineName(), k -> new ArrayList<>());
        sections.get(section.getLineName()).add(orderNum, new Station(section.getStationName()));
        addUsedStation(section.getStationName());
    }

    public static boolean deleteSectionByName(String lineName, String stationName) {
        boolean result = sections.get(lineName).removeIf(station -> Objects.equals(station.getName(), stationName));
        if (result) {
            deleteUsedStation(stationName);
        }
        return result;
    }

    public static boolean checkStationInLine(String stationName) {
        if (usedStations.contains(stationName)) {
            return true;
        }
        return false;
    }

    public static int getLineSectionSize(String lineName) {
        return sections.get(lineName).size();
    }

    private static void addUsedStation(String stationName) {
        usedStations.add(stationName);
    }

    private static void deleteUsedStation(String stationName) {
        usedStations.remove(stationName);
    }
}
