package subway.view;

import subway.line.domain.Line;
import subway.station.domain.Station;

import java.util.List;

import static subway.view.resource.Strings.*;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String GUIDE_PREFIX = "## ";

    private OutputView() {
    }

    public static void printStations(List<Station> stations) {
        printGuide(STATION_LIST);
        stations.forEach(OutputView::printStation);
    }

    private static void printStation(Station station) {
        printResult(station.getName());
    }

    public static void printLines(List<Line> lines) {
        printGuide(LINE_LIST);
        lines.forEach(OutputView::printLine);
    }

    public static void printSubwayMap(List<Line> lines) {
        printGuide(SUBWAY_MAP);
        lines.forEach(OutputView::printOneLineMap);
    }

    private static void printOneLineMap(Line line) {
        printResult(line.getName());
        printResult(DIVIDING_LINE);
        line.getStations().forEach(OutputView::printStation);
        System.out.println();
    }

    private static void printLine(Line line) {
        printResult(line.getName());
    }

    public static void printError(String message) {
        System.out.println();
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printlnResult(String message) {
        System.out.println();
        System.out.println(RESULT_PREFIX + message);
    }

    public static void printResult(String message) {
        System.out.println(RESULT_PREFIX + message);
    }

    public static void printGuide(String message) {
        System.out.println();
        System.out.println(GUIDE_PREFIX + message);
    }
}
