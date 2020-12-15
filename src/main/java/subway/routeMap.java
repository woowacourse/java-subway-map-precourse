package subway;

import static log.Logger.guidePrint;
import static subway.domain.LineRepository.lines;

import java.util.List;
import subway.domain.Line;

public class routeMap {
    public static void routeMapPrint() {
        guidePrint("지하철 노선도");

        List<Line> allLines = lines();
        for (Line line : allLines) {
            line.printAllInfo();
        }
    }
}
