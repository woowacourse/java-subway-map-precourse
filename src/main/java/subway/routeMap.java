package subway;

import static subway.domain.LineRepository.lines;

import java.util.List;
import subway.domain.Line;

public class routeMap {
    public static void routeMapPrint() {
        System.out.println("\n## 지하철 노선도\n");

        List<Line> allLines = lines();
        for (Line line : allLines) {
            line.printAllInfo();
        }
    }
}
