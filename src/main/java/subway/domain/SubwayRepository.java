package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayRepository {

    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> getSubway() {
        return subway;
    }

    public static void addStationOnTheLine(Line line, List<Station> sections) {
        subway.put(line, sections);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : subway.keySet()) {
            sb.append(PRINT_INFO + line.getName() + NEW_LINE);
            sb.append(PRINT_INFO + "---" + NEW_LINE);
            for (Station station : subway.get(line)) {
                sb.append(PRINT_INFO + station.getName() + NEW_LINE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
