package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;

public class SubwayMapOutputView extends OutputView {
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String SEPARATOR = "---";
    
    public static void printSubwayMap() {
        printMessage(SUBWAY_MAP);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printSubwayLine(line);
            printEmptyLine();
        }

        InputView.waitForEmptyInput();
    }

    private static void printSubwayLine(Line line) {
        printListItem(line.getName());
        printListItem(SEPARATOR);
        for (String station : line) {
            printListItem(station);
        }
    }
}
