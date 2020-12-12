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
}
