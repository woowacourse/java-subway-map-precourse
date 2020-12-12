package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineStationMappingRepository {
    private static final Map<Line, List<Station>> lineStationMapping = new HashMap<>();

    public static void createNewLine(String newLineName, String upEndStationName,
        String downEndStationName) {
        Line newLine = new Line(newLineName);
        Station upEndStation = StationRepository.findByName(upEndStationName);
        Station downEndStation = StationRepository.findByName(downEndStationName);
        LineRepository.addLine(newLine);
        lineStationMapping.put(newLine, new ArrayList<>() {
            {
                add(upEndStation);
                add(downEndStation);
            }
        });
    }
}
