package view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {

    public static final String MAIN_TITLE = "## 메인 화면";
    public static final String MAIN_MANAGE_STATION = "1. 역 관리";
    public static final String MAIN_MANAGE_LINE = "2. 노선 관리";
    public static final String MAIN_MANAGE_SECTION = "3. 구간 관리";
    public static final String MAIN_PRINT_LINE_MAP = "4. 지하철 노선도 출력";

    public static final String STATION_TITLE = "## 역 관리 화면";
    public static final String STATION_REGISTER = "1. 역 등록";
    public static final String STATION_DELETE = "2. 역 삭제";
    public static final String STATION_INQUIRY = "3. 역 조회";

    public static final String LINE_TITLE = "## 노선 관리 화면";
    public static final String LINE_REGISTER = "1. 노선 등록";
    public static final String LINE_DELETE = "2. 노선 삭제";
    public static final String LINE_INQUIRY = "3. 노선 조회";

    public static final String SECTION_TITLE = "## 구간 관리 화면";
    public static final String SECTION_REGISTER = "1. 구간 등록";
    public static final String SECTION_DELETE = "2. 구간 삭제";

    public static final String QUIT_MESSAGE = "Q. 종료";
    public static final String BACK_MESSAGE = "B. 돌아가기";

    public static final String TOTAL_MAP_TITLE = "## 지하철 노선도";
    public static final String TOTAL_STATION_TITLE = "## 역 목록";
    public static final String TOTAL_LINE_TITLE = "노선 목록";

    public static final String PREFIX_INFO = "[INFO] ";
    public static final String PREFIX_ERROR = "[ERROR] ";

    public static final String QUERY_FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    public static final String QUERY_REGISTER_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    public static final String QUERY_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    public static final String QUERY_REGISTER_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    public static final String QUERY_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    public static final String QUERY_REGISTER_LINE_NORTHBOUND_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String QUERY_REGISTER_LINE_SOUTHBOUND_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String QUERY_REGISTER_SECTION_LINE_NAME = "## 노선을 입력하세요.";
    public static final String QUERY_REGISTER_SECTION_STATION_NAME = "## 역이름을 입력하세요.";
    public static final String QUERY_REGISTER_SECTION_ORDER = "## 순서를 입력하세요.";
    public static final String QUERY_DELETE_SECTION_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String QUERY_DELETE_SECTION_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";

    public static final String MESSAGE_SUCCESS_REGISTER_STATION = "지하철 역이 등록되었습니다.";
    public static final String MESSAGE_SUCCESS_DELETE_STATION = "지하철 역이 삭제되었습니다.";
    public static final String MESSAGE_SUCCESS_REGISTER_LINE = "지하철 노선이 등록되었습니다.";
    public static final String MESSAGE_SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.";
    public static final String MESSAGE_SUCCESS_REGISTER_SECTION = "지하철 구간이 등록되었습니다.";
    public static final String MESSAGE_SUCCESS_DELETE_SECTION = "지하철 구간이 삭제되었습니다.";

    public static final String MESSAGE_ERROR_INVALID_SELECT = "선택할 수 없는 기능입니다.";
    public static final String MESSAGE_ERROR_ALREADY_EXIST_STATION_NAME = "이미 등록된 역입니다.";
    public static final String MESSAGE_ERROR_NOT_EXIST_STATION_NAME = "존재하지 않는 역입니다.";
    public static final String MESSAGE_ERROR_NOT_EXIST_STATION_NAME_IN_LINE = "에 존재하지 않는 역입니다.";
    public static final String MESSAGE_ERROR_UNDELETABLE_STATION_NAME = "삭제할 역은 어떠한 노선에도 포함되면 안됩니다.";
    public static final String MESSAGE_ERROR_STATION_NAME_SUFFIX = "역 이름은 '~역' 형태로 입력해주시길 바랍니다.";
    public static final String MESSAGE_ERROR_ALREADY_EXIST_LINE_NAME = "이미 등록된 노선입니다.";
    public static final String MESSAGE_ERROR_NOT_EXIST_LINE_NAME = "존재하지 않는 노선입니다.";
    public static final String MESSAGE_ERROR_UNDELETABLE_LINE_NAME = "삭제할 노선은 어떠한 구간도 포함되면 안됩니다.";
    public static final String MESSAGE_ERROR_LINE_NAME_SUFFIX = "노선 이름은 '~선' 형태로 입력해주시길 바랍니다.";
    public static final String MESSAGE_ERROR_SAME_NORTHBOUND_NAME = "상행 종점과 하행 종점의 이름은 달라야 합니다.";
    public static final String MESSAGE_ERROR_NOT_POSITIVE_INTEGER = "순서는 양의 정수 형태로 이루어져야 합니다.";
    public static final String MESSAGE_ERROR_OUT_OF_LINE_RANGE = "노선의 총 길이를 벗어난 값입니다.";
    public static final String MESSAGE_ERROR_TOO_SHORT_NAME = "이름은 2글자 이상이어야 합니다.";
    public static final String MESSAGE_ERROR_TOO_LITTLE_STATIONS = "노선에는 적어도 2개의 역이 존재해야 합니다.";

    public static final String NEW_LINE = "\n";
    public static final String DIVISION_LINE = "---";

    public static final String EXIT_PROGRAM = "프로그램을 종료하겠습니다.";

    public static void printMain() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_MANAGE_STATION);
        System.out.println(MAIN_MANAGE_LINE);
        System.out.println(MAIN_MANAGE_SECTION);
        System.out.println(MAIN_PRINT_LINE_MAP);
        System.out.println(QUIT_MESSAGE + NEW_LINE);
    }

    public static void printStationManagement() {
        System.out.println(STATION_TITLE);
        System.out.println(STATION_REGISTER);
        System.out.println(STATION_DELETE);
        System.out.println(STATION_INQUIRY);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printLineManagement() {
        System.out.println(LINE_TITLE);
        System.out.println(LINE_REGISTER);
        System.out.println(LINE_DELETE);
        System.out.println(LINE_INQUIRY);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printSectionManagement() {
        System.out.println(SECTION_TITLE);
        System.out.println(SECTION_REGISTER);
        System.out.println(SECTION_DELETE);
        System.out.println(BACK_MESSAGE + NEW_LINE);
    }

    public static void printTotalMap() {
        System.out.println(TOTAL_MAP_TITLE);
        for (Line line : LineRepository.lines()) {
            printInformation(line.getName());
            printInformation(DIVISION_LINE);
            printStationIn(line);
        }
    }

    public static void printStationIn(Line line) {
        for (String stationName : line.getStationsIncludedLine()) {
            printInformation(stationName);
        }
        System.out.println();
    }

    public static void printTotalStation() {
        System.out.println(TOTAL_STATION_TITLE);
        for (Station station : StationRepository.stations()) {
            printInformation(station.getName());
        }
        System.out.println();
    }

    public static void printTotalLine() {
        printInformation(TOTAL_LINE_TITLE);
        for (Line line : LineRepository.lines()) {
            printInformation(line.getName());
        }
        System.out.println();
    }

    public static void printError(String errorMessage) {
        System.out.println(PREFIX_ERROR + errorMessage + NEW_LINE);
    }

    public static void printInformation(String infoMessage) {
        System.out.println(PREFIX_INFO + infoMessage);
    }

}
