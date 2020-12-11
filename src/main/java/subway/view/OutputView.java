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

    public void printQuestions(Stream<String> questions) {
        printLine("");
        questions.forEach(this::printLine);
    }

    public void printRegisterSectionLineNameQuestion() {
        printLine(REGISTER_SECTION_LINE_NAME_QUESTION);
    }
    public void printRegisterSectionStationNameQuestion() {
        printLine(REGISTER_SECTION_STATION_NAME_QUESTION);
    }

    public void printRegisterSectionOrderNumberQuestion() {
        printLine(REGISTER_SECTION_ORDER_NUMBER_QUESTION);
    }

    public void printRegisterSectionSuccess() {
        printLine(REGISTER_SECTION_SUCCESS);
    }

    public void printDeleteSectionLineNameQuestion() {
        printLine(DELETE_SECTION_LINE_NAME_QUESTION);
    }

    public void printDeleteSectionStationNameQuestion() {
        printLine(DELETE_SECTION_STATION_NAME_QUESTION);
    }

    public void printDeleteSectionSuccess() {
        printInfo(DELETE_SECTION_SUCCESS);
    }


    public void printRegisterStationQuestion() {
        printLine(REGISTER_STATION_QUESTION);
    }

    public void printRegisterStationSuccess() {
        printInfo(REGISTER_STATION_SUCCESS);
    }

    public void printDeleteStationQuestion() {
        printLine(DELETE_STATION_QUESTION);
    }

    public void printDeleteStationSuccess() {
        printInfo(DELETE_STATION_SUCCESS);
    }

    public void printRegisterLineQuestion() {
        printLine(REGISTER_LINE_QUESTION);
    }

    public void printRegisterLineSuccess() {
        printInfo(REGISTER_LINE_SUCCESS);
    }

    public void printDeleteLineQuestion() {
        printLine(DELETE_LINE_QUESTION);
    }

    public void printStartStationQuestion() {
        printLine(START_STATION_QUESTION);
    }

    public void printEndStationQuestion() {
        printLine(END_STATION_QUESTION);
    }

    public void printDeleteLineSuccess() {
        printInfo(DELETE_LINE_SUCCESS);
    }

    public void printSubwayLineList(List<Line> lineList) {
        printLine(SUBWAY_LINE_LIST_HEADER);
        for (Line line : lineList) {
            printSubwayLineName(line);
        }
        printLine("");
    }

    public void printStationList(List<Station> stationList) {
        printLine(STATION_LIST_HEADER);
        printStationNames(stationList);
        printLine("");
    }

    public void printEntireSubwayLine(List<Line> lineList) {
        printLine(ENTIRE_SUBWAY_LINE_HEADER);
        for (Line line : lineList) {
            printSubwayLine(line);
            printLine("");
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

    public void printLine(String message) {
        System.out.println(message);
    }

    public void printInfo(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

}
