package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CHOOSE_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ENTIRE_SUBWAY_LINE_HEADER = "## 지하철 노선도";
    private static final String STATION_LIST_HEADER = "## 역 목록";
    private static final String SUBWAY_LINE_LIST_HEADER = "## 노선 목록";


    private static final String DASH = "---";

    private OutputView() {
    }

    public static void printHeader(String header) {
        printEnter();
        println(header);
    }

    public static void printQuestionOptions(Stream<String> questions) {
        questions.forEach(OutputView::println);
    }

    public static void printChooseOptionMessage() {
        printEnter();
        println(CHOOSE_OPTION_MESSAGE);
    }

    public static void printSubwayLineList(List<Line> lineList) {
        println(SUBWAY_LINE_LIST_HEADER);
        for (Line line : lineList) {
            printSubwayLineName(line);
        }
        printEnter();
    }

    public static void printStationList(List<Station> stationList) {
        println(STATION_LIST_HEADER);
        printStationNames(stationList);
        printEnter();
    }

    public static void printEntireSubwayLine(List<Line> lineList) {
        println(ENTIRE_SUBWAY_LINE_HEADER);
        for (Line line : lineList) {
            printSubwayLine(line);
            printEnter();
        }
    }

    private static void printSubwayLine(Line line) {
        printSubwayLineName(line);
        printInfo(DASH);
        printStationNames(line.getStations());
    }

    private static void printSubwayLineName(Line line) {
        printInfo(line.getName());
    }

    private static void printStationNames(List<Station> stationList) {
        for (Station station : stationList) {
            printInfo(station.getName());
        }
    }

    public static void printEnter() {
        println("");
    }

    public static void printInfo(String message) {
        println(INFO_PREFIX + message);
    }

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
