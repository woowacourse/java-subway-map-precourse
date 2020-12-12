package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.*;

public class TransitMapRepository {
    private static final Map<Line, LinkedList<Station>> transitMaps = new HashMap<>();

    public static Map<Line, LinkedList<Station>> transitMaps() {
        return Collections.unmodifiableMap(transitMaps);
    }

    public static void addTransitMap(Line line, LinkedList<Station> stationList) {
        transitMaps.put(line, stationList);
    }
}
