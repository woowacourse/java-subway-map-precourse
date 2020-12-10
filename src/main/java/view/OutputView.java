package view;

import subway.domain.Line;
import subway.domain.LineRepository;

public class OutputView {

    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String MAIN_MANAGE_STATION = "1. 역 관리";
    private static final String MAIN_MANAGE_LINE = "2. 노선 관리";
    private static final String MAIN_MANAGE_SECTION = "3. 구간 관리";
    private static final String MAIN_PRINT_LINE_MAP = "4. 지하철 노선도 출력";

    private static final String STATION_TITLE = "## 역 관리 화면";
    private static final String STATION_REGISTER = "1. 역 등록";
    private static final String STATION_DELETE = "2. 역 삭제";
    private static final String STATION_INQUIRY = "3. 역 조회";

    private static final String LINE_TITLE = "## 노선 관리 화면";
    private static final String LINE_REGISTER = "1. 노선 등록";
    private static final String LINE_DELETE = "2. 노선 삭제";
    private static final String LINE_INQUIRY = "3. 노선 조회";

    private static final String SECTION_TITLE = "## 구간 관리 화면";
    private static final String SECTION_REGISTER = "1. 구간 등록";
    private static final String SECTION_DELETE = "2. 구간 삭제";

    private static final String QUIT_MESSAGE = "Q. 종료";
    private static final String BACK_MESSAGE = "B. 돌아가기";

    private static final String LINE_MAP_TITLE = "## 지하철 노선도";

    private static final String PREFIX_INFO = "[INFO] ";
    private static final String PREFIX_ERROR = "[ERROR] ";

    private static final String QUERY_FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    private static final String QUERY_REGISTER_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String QUERY_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String QUERY_REGISTER_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String QUERY_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    private static final String QUERY_REGISTER_LINE_NORTHBOUND_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String QUERY_REGISTER_LINE_SOUTHBOUND_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String QUERY_REGISTER_SECTION_LINE_NAME = "## 노선을 입력하세요.";
    private static final String QUERY_REGISTER_SECTION_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String QUERY_REGISTER_SECTION_ORDER = "## 순서를 입력하세요.";
    private static final String QUERY_DELETE_SECTION_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String QUERY_DELETE_SECTION_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";

    private static final String MESSAGE_SUCCESS_REGISTER_STATION = "지하철 역이 등록되었습니다.";
    private static final String MESSAGE_SUCCESS_DELETE_STATION = "지하철 역이 삭제되었습니다.";
    private static final String MESSAGE_SUCCESS_REGISTER_LINE = "지하철 노선이 등록되었습니다.";
    private static final String MESSAGE_SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.";
    private static final String MESSAGE_SUCCESS_REGISTER_SECTION = "지하철 구간이 등록되었습니다.";
    private static final String MESSAGE_SUCCESS_DELETE_SECTION = "지하철 구간이 삭제되었습니다.";
    private static final String MESSAGE_ERROR_INVALID_SELECT = "선택할 수 없는 기능입니다.";
    private static final String MESSAGE_ERROR_ALREADY_EXIST_STATION_NAME = "이미 등록된 역입니다.";
    private static final String MESSAGE_ERROR_NOT_EXIST_STATION_NAME = "존재하지 않는 역입니다.";
    private static final String MESSAGE_ERROR_ALREADY_EXIST_LINE_NAME = "이미 등록된 노선입니다.";
    private static final String MESSAGE_ERROR_NOT_EXIST_LINE_NAME = "존재하지 않는 노선입니다.";

    private static final String NEW_LINE = "\n";
    private static final String DIVISION_LINE = "---";

    public static void printMain() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_MANAGE_STATION);
        System.out.println(MAIN_MANAGE_LINE);
        System.out.println(MAIN_MANAGE_SECTION);
        System.out.println(MAIN_PRINT_LINE_MAP);
        System.out.println(QUIT_MESSAGE + NEW_LINE);
    }

    public static void printStationManagement() { // 1
        System.out.println(STATION_TITLE);
        System.out.println(STATION_REGISTER);
        System.out.println(STATION_DELETE);
        System.out.println(STATION_INQUIRY);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printLineManagement() { // 2
        System.out.println(LINE_TITLE);
        System.out.println(LINE_REGISTER);
        System.out.println(LINE_DELETE);
        System.out.println(LINE_INQUIRY);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printSectionManagement() { // 3
        System.out.println(SECTION_TITLE);
        System.out.println(SECTION_REGISTER);
        System.out.println(SECTION_DELETE);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printLineMap() { // 4
        System.out.println(LINE_MAP_TITLE);
        for (Line line : LineRepository.lines()) {
            System.out.println(PREFIX_INFO + line.getName());
            System.out.println(PREFIX_INFO + DIVISION_LINE);
            printStationIn(line);
        }
    }

    public static void printStationIn(Line line) {
        for (String station : line.getContainedStation()) {
            System.out.println(PREFIX_INFO + station);
        }
        System.out.println();
    }

}
