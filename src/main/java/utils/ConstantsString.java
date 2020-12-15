package utils;

public class ConstantsString {
    public static final String MAIN_MENU =
            "## 메인 화면\n1. 역관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    public static final String LINE_MANAGE_MENU =
            "## 노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기\n";
    public static final String DIVISION_DASH = "---";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_BACK = "B";
    public static final String INVALID_INPUT = ERROR_PREFIX + "유효하지 않은 입력입니다.";
    public static final String INPUT_ADD_LINE = "1";
    public static final String INPUT_REMOVE_LINE = "2";
    public static final String INPUT_SHOW_LINES = "3";
    public static final String INPUT_MESSAGE_LINE_NAME_TO_DELETE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String INPUT_MESSAGE_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    public static final String INPUT_MESSAGE_UPWARD_DESTINATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_MESSAGE_DOWNWARD_DESTINATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String LINE_LIST = INFO_PREFIX + "노선 목록";
    public static final String COMPLETE_ADD_LINE = INFO_PREFIX + "지하철 노선이 등록되었습니다.";
    public static final String COMPLETE_REMOVE_LINE = INFO_PREFIX + "지하철 노선이 삭제되었습니다.";
    public static final String ERROR_EXIST_LINE = ERROR_PREFIX + "이미 존재하는 노선입니다.\n";
    public static final String ERROR_NOT_EXIST_STATION = ERROR_PREFIX + "역이 존재하지 않습니다.";
    public static final String ERROR_NOT_EXIST_DESTINATION_STATION =
            ERROR_PREFIX + "상행 종점역 또는 하행 종점역이 존재하지 않니다.\n";
    public static final String ERROR_NOT_EXIST_LINE_TO_DELETE =
            ERROR_PREFIX + "삭제할 노선이 존재하지 않니다.\n";
    public static final String ERROR_INPUT_MORE_THAN_TWO = ERROR_PREFIX + "2글자 이상 입력해주세요.\n";
    public static final String INPUT_ADD_SECTION = "1";
    public static final String INPUT_REMOVE_SECTION = "2";
    public static final String INPUT_MESSAGE_STATION_NAME = "## 역이름을 입력하세요.";
    public static final String INPUT_MESSAGE_POSITION = "## 순서를 입력하세요.";
    public static final String INPUT_MESSAGE_STATION_NAME_TO_DELETE = "## 삭제할 구간의 역을 입력하세요.";
    public static final String COMPLETE_ADD_SECTION = INFO_PREFIX + "구간이 등록되었습니다.";
    public static final String COMPLETE_REMOVE_SECTION = INFO_PREFIX + "구간이 삭제되었습니다.";
    public static final String ERROR_NOT_EXIST_LINE = ERROR_PREFIX + "존재하지 않는 노선입니다.";
    public static final String ERROR_INPUT_ONLY_NUMBER = ERROR_PREFIX + "위치에 숫자만 입력해주세요.";
    public static final String ERROR_NOT_EXIST_STATION_IN_LINE =
            ERROR_PREFIX + "노선에 존재하지 않는 구간입니다.";
    public static final String ERROR_EXIST_STATION_IN_LINE = ERROR_PREFIX + "이미 노선에 존재하는 구간입니다.";
    public static final String ERROR_SECTION_LESS_THAN_TWO =
            ERROR_PREFIX + "구간에 역이 2개 이하로 존재하는 경우 삭제할 수 없습니다.";
    public static final String ERROR_CAN_NOT_ADD_POSITION_AT =
            ERROR_PREFIX + "해당 위치에 구간을 추가 할 수 없습니다.";
    public static final String SECTION_MANAGE_MENU =
            "## 구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    public static final String STATION_MANAGE_MENU =
            "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n";
    public static final int INPUT_MANAGE_STATION = 1;
    public static final int INPUT_MANAGE_LINE = 2;
    public static final int INPUT_MANAGE_SECTION = 3;
    public static final int INPUT_PRINT_LINES = 4;
    public static final String INPUT_QUIT = "Q";

    public static final String INPUT_ADD_STATION = "1";
    public static final String INPUT_REMOVE_STATION = "2";
    public static final String INPUT_SHOW_STATIONS = "3";

    public static final String ERROR_INVALID_INPUT = ERROR_PREFIX + "유효하지 않은 입력입니다.";
    public static final String ERROR_DUPLICATE_STATION_NAME = ERROR_PREFIX + "이미 등록된 역이 존재합니다.";
    public static final String ERROR_STATION_NAME_LESS_THAN_TWO =
            ERROR_PREFIX + "역이름은 2글자 이상이여야 합니다.";
    public static final String ERROR_STATION_NAME_NOT_EXIST = ERROR_PREFIX + "해당 역이 존재하지 않습니다.";
    public static final String ERROR_STATION_IN_LINES = ERROR_PREFIX + "노선에 존재하는 역은 삭제할 수 없습니다.";
    public static final String COMPLETE_REMOVE_STATION = INFO_PREFIX + "지하철 역이 삭제되었습니다.";
    public static final String MESSAGE_ADD_COMPLETE = INFO_PREFIX + "지하철 역이 등록되었습니다.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
}
