package subway.domain;

import java.util.*;

public class SubwayRepository {
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> subway() {
        return Collections.unmodifiableMap(subway);
    }

    public static void addLineStation(Line line, Station station, Integer order) {
        if (subway.containsKey(line)) {
            subway.get(line).add(order, station);
        }
    }

    public static void addLine(Line lineByName) {
        subway.put(lineByName, new ArrayList<>());
    }

    public static boolean findStationByName(String inputRemoveName) {
        boolean flag = false;
        for(Line line: subway.keySet()){
            if(subway.get(line).stream().anyMatch(station -> station.getName().equals(inputRemoveName))){
                flag = true;
            }
        }
        return flag;
    }
}
