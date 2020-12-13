package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;

import java.util.*;

public class TransitMapRepository {
    private static final Map<Line, LinkedList<Station>> transitMaps = new LinkedHashMap<>();

    public static Map<Line, LinkedList<Station>> transitMaps() {
        return Collections.unmodifiableMap(transitMaps);
    }

    public static void addTransitMap(TransitMap transitMap) {
        transitMaps.put(transitMap.getTransitMapLine(), transitMap.getTransitMapStations());
    }

    public static void deleteTransitMap(Line line) {
        transitMaps.remove(line);
    }

    public static List<LinkedList<String>> transitMapsStationNames() {
        List<LinkedList<String>> transitMapsStationNames = new ArrayList<>();

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            LinkedList<String> transitMapStationNames = new LinkedList<>();
            LinkedList<Station> values = entry.getValue();

            for (Station value : values) {
                transitMapStationNames.add(value.getName());
            }
            transitMapsStationNames.add(transitMapStationNames);
        }
        return transitMapsStationNames;
    }
}
