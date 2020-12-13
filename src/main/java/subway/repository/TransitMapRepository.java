package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;

import java.util.*;

public class TransitMapRepository {
    private static final Map<Line, LinkedList<Station>> transitMaps = new LinkedHashMap<>();
    private static final List<LinkedList<String>> transitMapsStationNames = new ArrayList<>();

    public static Map<Line, LinkedList<Station>> transitMaps() {
        return Collections.unmodifiableMap(transitMaps);
    }

    public static List<LinkedList<String>> transitMapsStationNames() {
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

    public static void addTransitMap(TransitMap transitMap) {
        transitMaps.put(transitMap.getTransitMapLine(), transitMap.getTransitMapStations());
    }
}
