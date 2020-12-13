package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubwayRepository {

    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> getSubway() {
        return subway;
    }

    public static void addStationOnTheLine(Line line, List<Station> stations) {
        subway.put(line, stations);
    }

    public static void deleteLineOnSubway(String lineName) {
        for (Line line : subway.keySet()) {
            if (Objects.equals(line.getName(), lineName))
                subway.remove(line);
        }
    }

    public static void addSectionOnTheLine(String lineName, String sectionName, String order) {

    }

    public static void deleteSectionOnTheLine(String stationName) {

    }

    public static boolean isLineInStationsOverTwo(String lineName) {
        Line line = LineRepository.getLine(lineName);
        List<Station> stations = subway.get(line);
        if (stations.size() == 2)
            return false;
        return true;
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
