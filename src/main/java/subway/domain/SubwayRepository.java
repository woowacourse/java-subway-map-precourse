package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayRepository {
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> getSubway() {
        return subway;
    }

    public static void addStationOnTheLine(Line line, List<Station> sections) {
        subway.put(line, sections);
    }

}
