package subway.view;

import java.util.List;
import java.util.Map;

public class SubwayMapView {
    public static void printMap(Map<String, List<String>> subwayMap) {
        System.out.println("\n## 지하철 노선도");
        for (String line : subwayMap.keySet()) {
            System.out.println("[INFO] " + line);
            System.out.println("[INFO] ---");
            for (String station : subwayMap.get(line)) {
                System.out.println("[INFO] " + station);
            }
            System.out.println();
        }
    }
}
