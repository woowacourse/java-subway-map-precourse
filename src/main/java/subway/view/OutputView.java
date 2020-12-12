package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ENTIRE_SUBWAY_LINE_HEADER = "## 지하철 노선도";
    private static final String STATION_LIST_HEADER = "## 역 목록";
    private static final String SUBWAY_LINE_LIST_HEADER = "## 노선 목록";
    private static final String REGISTER_STATION_QUESTION = "## 등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_QUESTION = "## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.";
    private static final String REGISTER_LINE_QUESTION = "## 등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_QUESTION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_QUESTION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String REGISTER_LINE_SUCCESS = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_QUESTION = "## 삭제할 노선 이름을 입력하세요.";
    private static final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.";
    private static final String REGISTER_SECTION_LINE_NAME_QUESTION = "## 노선을 입력하세요.";
    private static final String REGISTER_SECTION_STATION_NAME_QUESTION = "## 역이름을 입력하세요.";
    private static final String REGISTER_SECTION_ORDER_NUMBER_QUESTION = "## 순서를 입력하세요.";
    private static final String REGISTER_SECTION_SUCCESS = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_LINE_NAME_QUESTION = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_SECTION_STATION_NAME_QUESTION = "## 삭제할 구간의 역을 입력하세요.";
    private static final String DELETE_SECTION_SUCCESS = "구간이 삭제되었습니다.";
    private static final String DASH = "---";

    private OutputView() {
    }

    public static void printQuestionHeader(String header) {
        printEnter();
        println(header);
    }

    public static void printQuestions(Stream<String> questions) {
        questions.forEach(OutputView::println);
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

    // Station
    public static void printRegisterStationQuestion() {
        println(REGISTER_STATION_QUESTION);
    }

    public static void printRegisterStationSuccess() {
        printInfo(REGISTER_STATION_SUCCESS);
    }

    public static void printDeleteStationQuestion() {
        println(DELETE_STATION_QUESTION);
    }

    public static void printDeleteStationSuccess() {
        printInfo(DELETE_STATION_SUCCESS);
    }

    // Line
    public static void printRegisterLineQuestion() {
        println(REGISTER_LINE_QUESTION);
    }

    public static void printRegisterLineSuccess() {
        printInfo(REGISTER_LINE_SUCCESS);
    }

    public static void printLineStartStationQuestion() {
        println(START_STATION_QUESTION);
    }

    public static void printLineEndStationQuestion() {
        println(END_STATION_QUESTION);
    }

    public static void printDeleteLineQuestion() {
        println(DELETE_LINE_QUESTION);
    }

    public static void printDeleteLineSuccess() {
        printInfo(DELETE_LINE_SUCCESS);
    }

    // Section
    public static void printRegisterSectionLineNameQuestion() {
        println(REGISTER_SECTION_LINE_NAME_QUESTION);
    }

    public static void printRegisterSectionStationNameQuestion() {
        println(REGISTER_SECTION_STATION_NAME_QUESTION);
    }

    public static void printRegisterSectionOrderNumberQuestion() {
        println(REGISTER_SECTION_ORDER_NUMBER_QUESTION);
    }

    public static void printRegisterSectionSuccess() {
        println(REGISTER_SECTION_SUCCESS);
    }

    public static void printDeleteSectionLineNameQuestion() {
        println(DELETE_SECTION_LINE_NAME_QUESTION);
    }

    public static void printDeleteSectionStationNameQuestion() {
        println(DELETE_SECTION_STATION_NAME_QUESTION);
    }

    public static void printDeleteSectionSuccess() {
        printInfo(DELETE_SECTION_SUCCESS);
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
