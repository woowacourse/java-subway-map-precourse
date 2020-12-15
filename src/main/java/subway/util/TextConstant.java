package subway.util;

public class TextConstant {
    // 공통
    public static final int ZERO = 0;
    public static final int NAME_MIN_LENGTH = 2;

    //지하철 역(Station) 관련
    public static final int STATION_MINIMUM_SIZE = 2;

    public static final String STATION = "역";
    public static final String ADD = "등록";
    public static final String DELETE = "삭제";
    public static final String SUBWAY_STATION = "지하철 역";

    public static final String ERR_WRONG_STATION_NAME_SUFFIX = "[ERROR] 역의 이름은 ~역 형태여야 합니다.";
    public static final String ERR_ALREADY_ADD_STATION_NAME_MSG = "[ERROR] 이미 등록된 역명입니다.";
    public static final String ERR_NO_SUCH_NAME_STATION_MSG = "[ERROR] 해당 역이 없습니다.";
    public static final String ERR_STATION_SHORT_NAME_MSG =
            String.format("[ERROR] 역의 이름은 %d글자 이상이어야 합니다.", NAME_MIN_LENGTH);

    //노선(Line) 관련
    public static final String LINE = "선";
    public static final String ROUTE = "노선";
    public static final String UPLINE_TERMINAL_STATION = "노선의 상행 종점역";
    public static final String DOWNLINE_TERMINAL_STATION = "노선의 하행 종점역";

    public static final String ERR_NO_SUCH_NAME_LINE_MSG = "[ERROR] 해당 노선이 없습니다.";
    public static final String ERR_ALREADY_ADD_LINE_NAME_MSG = "[ERROR] 이미 등록된 노선명입니다.";
    public static final String ERR_WRONG_LINE_NAME_SUFFIX = "[ERROR] 노선의 이름은 ~선 형태여야 합니다.";
    public static final String ERR_OTHER_TERMINAL_NOT_EQUALS = "[ERROR] 상행선 종점역과 하행선 종점역은 같을 수 없습니다.";
    public static final String ERR_POOR_SIZE_OF_STATION_MSG =
            String.format("[ERROR] 노선에 등록된 역의 개수는 %d개 보다 많아야 합니다.", STATION_MINIMUM_SIZE);
    public static final String ERR_SHORT_NAME_MSG =
            String.format("[ERROR] 노선의 이름은 %d글자 이상이어야 합니다.", NAME_MIN_LENGTH);

    //구간(Section) 관련
    public static final String SECTION = "구간";
    public static final String SEQUENCE = "순서";
    public static final String REQUEST_INPUT_MSG_FORMAT = "## %s을(를) 입력하세요.";

    //메뉴 관련
    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    //콘솔 화면(OutPutView) 출력 관련
    public static final String DOT_AND_BLANK = ". ";
    public static final String EMPTY_STRING = "";
    public static final String INFO_PREFIX_MSG = "[INFO] ";
    public static final String MAIN_MENU_HEADER = "## 메인 화면";
    public static final String STATION_MENU_HEADER = "## 역 관리 화면";
    public static final String LINE_MENU_HEADER = "## 노선 관리 화면";
    public static final String SECTION_MENU_HEADER = "## 구간 관리 화면";
    public static final String PLEASE_SELECT_MENU_MSG = "## 원하는 기능을 선택하세요.";
    public static final String REQUEST_INPUT_FOR_ADD_NAME_MSG_FORMAT = "## 등록할 %s 이름을 입력하세요.";
    public static final String REQUEST_INPUT_FOR_DELETE_NAME_MSG_FORMAT = "## 삭제할 %s 이름을 입력하세요.";
    public static final String INFO_COMPLETE_MSG_FORMAT = INFO_PREFIX_MSG.concat("%s이 %s되었습니다.");
    public static final String INFO_NO_ELEMENT_FORMAT = INFO_PREFIX_MSG.concat("%s이 없습니다.");
}
