package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {
    private final String INFO_PREFIX = "[INFO] ";
    private final String ERROR_PREFIX = "[ERROR] ";
    private final String ENTIRE_SUBWAY_LINE_HEADER = "## 지하철 노선도";
    private final String STATION_LIST_HEADER = "## 역 목록";
    private final String SUBWAY_LINE_LIST_HEADER = "## 노선 목록";
    private final String REGISTER_STATION_QUESTION = "## 등록할 역 이름을 입력하세요.";
    private final String REGISTER_STATION_SUCCESS = "지하철 역이 등록되었습니다.";
    private final String DELETE_STATION_QUESTION = "## 삭제할 역 이름을 입력하세요.";
    private final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.";
    private final String REGISTER_LINE_QUESTION = "## 등록할 노선 이름을 입력하세요.";
    private final String START_STATION_QUESTION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String END_STATION_QUESTION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final String REGISTER_LINE_SUCCESS = "지하철 노선이 등록되었습니다.";
    private final String DELETE_LINE_QUESTION = "## 삭제할 노선 이름을 입력하세요.";
    private final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.";
    private final String REGISTER_SECTION_LINE_NAME_QUESTION = "## 노선을 입력하세요.";
    private final String REGISTER_SECTION_STATION_NAME_QUESTION = "## 역이름을 입력하세요.";
    private final String REGISTER_SECTION_ORDER_NUMBER_QUESTION = "## 순서를 입력하세요.";
    private final String REGISTER_SECTION_SUCCESS = "구간이 등록되었습니다.";
    private final String DELETE_SECTION_LINE_NAME_QUESTION = "## 삭제할 구간의 노선을 입력하세요.";
    private final String DELETE_SECTION_STATION_NAME_QUESTION = "## 삭제할 구간의 역을 입력하세요.";
    private final String DELETE_SECTION_SUCCESS = "구간이 삭제되었습니다.";
    private final String DASH = "---";

    public OutputView() {
    }

    public void printQuestionHeader(String header) {
        printEnter();
        println(header);
    }

    public void printQuestions(List<String> questions) {
        questions.forEach(this::println);
    }

    public void printSubwayLineList(List<Line> lineList) {
        println(SUBWAY_LINE_LIST_HEADER);
        for (Line line : lineList) {
            printSubwayLineName(line);
        }
        printEnter();
    }

    public void printStationList(List<Station> stationList) {
        println(STATION_LIST_HEADER);
        printStationNames(stationList);
        printEnter();
    }

    public void printEntireSubwayLine(List<Line> lineList) {
        println(ENTIRE_SUBWAY_LINE_HEADER);
        for (Line line : lineList) {
            printSubwayLine(line);
            printEnter();
        }
    }

    private void printSubwayLine(Line line) {
        printSubwayLineName(line);
        printInfo(DASH);
        printStationNames(line.getStations());
    }

    private void printSubwayLineName(Line line) {
        printInfo(line.getName());
    }

    private void printStationNames(List<Station> stationList) {
        for (Station station : stationList) {
            printInfo(station.getName());
        }
    }

    // Station
    public void printRegisterStationQuestion() {
        println(REGISTER_STATION_QUESTION);
    }

    public void printRegisterStationSuccess() {
        printInfo(REGISTER_STATION_SUCCESS);
    }

    public void printDeleteStationQuestion() {
        println(DELETE_STATION_QUESTION);
    }

    public void printDeleteStationSuccess() {
        printInfo(DELETE_STATION_SUCCESS);
    }

    // Line
    public void printRegisterLineQuestion() {
        println(REGISTER_LINE_QUESTION);
    }

    public void printRegisterLineSuccess() {
        printInfo(REGISTER_LINE_SUCCESS);
    }

    public void printLineStartStationQuestion() {
        println(START_STATION_QUESTION);
    }

    public void printLineEndStationQuestion() {
        println(END_STATION_QUESTION);
    }

    public void printDeleteLineQuestion() {
        println(DELETE_LINE_QUESTION);
    }

    public void printDeleteLineSuccess() {
        printInfo(DELETE_LINE_SUCCESS);
    }

    // Section
    public void printRegisterSectionLineNameQuestion() {
        println(REGISTER_SECTION_LINE_NAME_QUESTION);
    }

    public void printRegisterSectionStationNameQuestion() {
        println(REGISTER_SECTION_STATION_NAME_QUESTION);
    }

    public void printRegisterSectionOrderNumberQuestion() {
        println(REGISTER_SECTION_ORDER_NUMBER_QUESTION);
    }

    public void printRegisterSectionSuccess() {
        println(REGISTER_SECTION_SUCCESS);
    }

    public void printDeleteSectionLineNameQuestion() {
        println(DELETE_SECTION_LINE_NAME_QUESTION);
    }

    public void printDeleteSectionStationNameQuestion() {
        println(DELETE_SECTION_STATION_NAME_QUESTION);
    }

    public void printDeleteSectionSuccess() {
        printInfo(DELETE_SECTION_SUCCESS);
    }

    public void printEnter() {
        println("");
    }

    public void printInfo(String message) {
        println(INFO_PREFIX + message);
    }

    public void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}
