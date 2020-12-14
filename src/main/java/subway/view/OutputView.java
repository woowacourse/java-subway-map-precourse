package subway.view;

import subway.domain.LineRepository;

public class OutputView {

    private static final String MAIN_PAGE = "## 메인화면\n" +
            "1. 역 관리\n" +
            "2. 노선관리\n" +
            "3. 구간관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";
    private static final String STATION_MAINTAIN = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n";
    private static final String LINE_MAINTAIN = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기\n";
    private static final String SECTION_MAINTAIN = "## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기\n";
    private static final String WRITE_OPERATION = "## 원하는 기능을 선택하세요.";
    private static final String WRITE_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String COMPLETE_REGISTER_STATION = "[INFO] 지하철 역이 등록되었습니다.\n";
    private static final String DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String COMPLETE_DELETE_STATION = "[INFO] 지하철 역이 삭제되었습니다.\n";
    private static final String INFO = "[INFO] ";
    private static final String SPACE = "";
    private static final String STATION_STATUS = "## 역 목록";
    private static final String WRITE_START_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String WRITE_END_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String WRITE_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String COMPLETE_REGISTER_LINE = "[INFO] 지하철 노선이 등록되었습니다.\n";
    private static final String DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    private static final String COMPLETE_DELETE_LINE = "[INFO] 지하철 노선이 삭제되었습니다.\n";
    private static final String LINE_STATUS = "## 노선 목록";
    private static final String WRITE_ORDER_NUMBER = "## 순서를 입력하세요.";
    private static final String COMPLETE_REGISTER_SECTION = "[INFO] 구간이 등록되었습니다.\n";
    private static final String WRITE_DELETE_STATION = "## 삭제할 구간의 역을 입력하세요.";
    private static final String COMPLETE_DELETE_SECTION = "[INFO] 구간이 삭제되었습니다.\n";
    private static final String WRITE_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";

    public static void print(String string) {
        System.out.println(string);
    }

    public static void mainPage() {
        print(MAIN_PAGE);
    }

    public static void writeOperation() {
        print(WRITE_OPERATION);
    }

    public static void stationMaintain() {
        print(STATION_MAINTAIN);
    }

    public static void writeStationName() {
        print(WRITE_STATION_NAME);
    }

    public static void completeRegisterStation() {
        print(COMPLETE_REGISTER_STATION);
    }

    public static void deleteStationName() {
        print(DELETE_STATION_NAME);
    }

    public static void completeDeleteStation() {
        print(COMPLETE_DELETE_STATION);
    }

    public static void status(String name) {
        print(INFO + name);
    }

    public static void space() {
        print(SPACE);
    }

    public static void lineMaintain() {
        print(LINE_MAINTAIN);
    }

    public static void stationStatus() {
        print(STATION_STATUS);
    }

    public static void writeLineName() {
        print(WRITE_LINE_NAME);
    }

    public static void completeRegisterLine() {
        print(COMPLETE_REGISTER_LINE);
    }

    public static void writeStartStation() {
        print(WRITE_START_STATION);
    }

    public static void writeEndStation() {
        print(WRITE_END_STATION);
    }

    public static void deleteLineName() {
        print(DELETE_LINE_NAME);
    }

    public static void completeDeleteLine() {
        print(COMPLETE_DELETE_LINE);
    }

    public static void lineStatus() {
        print(LINE_STATUS);
    }

    public static void sectionMaintain() {
        print(SECTION_MAINTAIN);
    }

    public static void writeOrderNumber() {
        print(WRITE_ORDER_NUMBER);
    }

    public static void completeRegisterSection() {
        print(COMPLETE_REGISTER_SECTION);
    }

    public static void writeDeleteStation() {
        print(WRITE_DELETE_STATION);
    }

    public static void completeDeleteSection() {
        print(COMPLETE_DELETE_SECTION);
    }

    public static void DeleteLineName() {
        print(WRITE_DELETE_LINE_NAME);
    }
}
