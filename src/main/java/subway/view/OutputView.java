package subway.view;

import subway.line.domain.Line;
import subway.station.domain.Station;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String GUIDE_PREFIX = "## ";
    private static final String LINE_LIST = "노선 목록";

    private OutputView() {
    }

    public static void printStation(Station station) {
        printResultMessage(station.getName());
    }

    public static void printLines(List<Line> lines) {
        OutputView.printResultMessage(LINE_LIST);
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        OutputView.printResultMessage(line.getName());
    }

    public static void printErrorMessage(String message) {
        printMessage(ERROR_PREFIX + message);
    }

    public static void printResultMessage(String message) {
        printMessage(RESULT_PREFIX + message);
    }

    public static void printGuideMessage(String message) {
        printMessage(GUIDE_PREFIX + message);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
