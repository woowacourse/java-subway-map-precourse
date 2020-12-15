package subway.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubwayMap {
    private Map<String, List<String>> subwayMap = new LinkedHashMap<>();

    public Map<String, List<String>> makeSubwayMap() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            putLineInMap(line);
            putStationInMap(line);
        }
        return subwayMap;
    }

    private void putLineInMap(Line line) {
        subwayMap.put(line.getName(), new ArrayList<String>());
    }

    private void putStationInMap(Line line) {
        String lineName = line.getName();
        for (Station station : line.getStations()) {
            String stationName = station.getName();
            List<String> lineOfSubwayMap = subwayMap.get(lineName);
            lineOfSubwayMap.add(stationName);
        }
    }
}
