package subway.view;

import subway.line.domain.Line;
import subway.station.domain.Station;
import subway.view.resource.LineMessage;
import subway.view.resource.StationMessage;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String GUIDE_PREFIX = "## ";

    private OutputView() {
    }

    public static void printStations(List<Station> stations) {
        OutputView.printGuideMessage(StationMessage.STATION_LIST);
        stations.forEach(OutputView::printStation);
    }

    private static void printStation(Station station) {
        OutputView.printResultMessage(station.getName());
    }

    public static void printLines(List<Line> lines) {
        OutputView.printGuideMessage(LineMessage.LINE_LIST);
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
