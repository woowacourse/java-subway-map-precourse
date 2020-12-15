package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;

import java.util.*;

/**
 * TransitMapRepository.java : 지하철 노선도에 대한 저장소 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
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

    public static List<String> transitMapsLineNames() {
        List<String> transitMapsLineNames = new ArrayList<>();

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            transitMapsLineNames.add(key.getName());
        }
        return transitMapsLineNames;
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

    public static List<String> transitMapStations(String lineName) {
        List<String> transitMapStations = new ArrayList<>();

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            String keyName = key.getName();
            LinkedList<Station> values = entry.getValue();

            if (keyName.equals(lineName)) {
                transitMapStations = getTransitMapStations(values);
            }
        }
        return transitMapStations;
    }

    public static List<String> getTransitMapStations(LinkedList<Station> values) {
        List<String> transitMapStations = new ArrayList<>();

        for (Station value : values) {
            transitMapStations.add(value.getName());
        }
        return transitMapStations;
    }
}
