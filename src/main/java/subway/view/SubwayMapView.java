package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubwayMapView {
    public static void printMap(Map<String, List<String>> subwayMap) {
        System.out.println("\n## 지하철 노선도");
        for (String line : subwayLines(subwayMap)) {
            printLine(line);
            printStations(subwayMap, line);
            OutputView.printLineBreak();
        }
    }

    private static Set<String> subwayLines(Map<String, List<String>> subwayMap) {
        return subwayMap.keySet();
    }

    private static void printLine(String line) {
        System.out.println("[INFO] " + line);
        System.out.println("[INFO] ---");
    }

    private static void printStations(Map<String, List<String>> subwayMap, String line) {
        for (String station : subwayMap.get(line)) {
            System.out.println("[INFO] " + station);
        }
    }
}
