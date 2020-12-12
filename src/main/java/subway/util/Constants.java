package subway.util;

public class Constants {

    public static final String MAIN_MENU_STATE = "MAIN";
    public static final String STATION_MENU_STATE = "STATION";
    public static final String LINE_MENU_STATE = "LINE";
    public static final String SECTION_MENU_STATE = "SECTION";

    public final static char EXIT_INPUT_CHARACTER = 'Q';
    public final static char BACKWARD_INPUT_CHARACTER = 'B';

    public final static int MIN_NAME_STRING_LENGTH = 2;
    public final static int INDEX_ARRANGE_INT = 1;
    public final static String LINE_BLANK = " ";

    public final static String PREFIX_INFO = "[INFO] ";
    public final static String PREFIX_ERROR = "[ERROR] ";

    public final static String INVALID_STRING_OUTPUT_COMMENT = "선택할 수 없는 기능입니다.";
    public final static String INVALID_STRING_ERROR_COMMENT = "잘못된 문자 입력입니다.";
    public final static String INVALID_LENGTH_ERROR_COMMENT = "길이를 초과 합니다.";
    public final static String INVALID_MIN_LENGTH_ERROR_COMMENT =
        "문자 길이가 " + MIN_NAME_STRING_LENGTH + " 이상 필요 합니다.";


    public final static String[] SCREEN_MENU_MAIN = {
        "## 메인 화면"
        , "1. 역 관리"
        , "2. 노선 관리"
        , "3. 구간 관리"
        , "4. 지하철 노선도 출력"
        , "Q. 종료"};

    public final static String ANNOUNCEMENT_FEATURE_SELECT_COMMENT = "## 원하는 기능을 선택하세요.";

    public final static String[] SCREEN_MENU_STATION_MANAGEMENT = {
        "## 역 관리 화면"
        , "1. 역 등록"
        , "2. 역 삭제"
        , "3. 역 조회"
        , "B. 돌아가기"};

    public final static String ADD_STATION_INPUT_COMMENT = "## 등록할 역 이름을 입력하세요.";
    public final static String ADD_STATION_OUTPUT_COMMENT = "지하철 역이 등록되었습니다.";
    public final static String DELETE_STATION_INPUT_COMMENT = "## 삭제할 역 이름을 입력하세요.";
    public final static String DELETE_STATION_OUTPUT_COMMENT = "지하철 역이 삭제되었습니다.";
    public final static String TITLE_WHOLE_STATION_TEXT = "## 역 목록";
    public final static String EXIST_STATION_OUTPUT_COMMENT = "이미 등록된 역 이름입니다.";
    public final static String EXIST_STATION_IN_SECTION_OUTPUT_COMMENT = "구간에 등록되어 있는 역 입니다. 구간을 먼저 삭제해 주세요.";
    public final static String NO_EXIST_STATION_OUTPUT_COMMENT = "존재하지 않는 역 이름입니다.";

    public final static String[] SCREEN_MENU_LINE_MANAGEMENT = {
        "## 노선 관리 화면"
        , "1. 노선 등록"
        , "2. 노선 삭제"
        , "3. 노선 조회"
        , "B. 돌아가기"
    };

    public final static String ADD_LINE_NAME_INPUT_COMMENT = "## 등록할 노선 이름을 입력하세요.";
    public final static String ADD_LINE_START_STATION_NAME_INPUT_COMMENT = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public final static String ADD_LINE_END_STATION_NAME_INPUT_COMMENT = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public final static String ADD_LINE_OUTPUT_COMMENT = "지하철 노선이 등록되었습니다.";
    public final static String DELETE_LINE_END_STATION_NAME_INPUT_COMMENT = "## 삭제할 노선 이름을 입력하세요.";
    public final static String DELETE_LINE_OUTPUT_COMMENT = "지하철 노선이 삭제되었습니다.";
    public final static String TITLE_WHOLE_LINE_TEXT = "## 노선 목록";
    public final static String EXIST_LINE_OUTPUT_COMMENT = "이미 등록된 노선 이름입니다.";
    public final static String NO_EXIST_LINE_OUTPUT_COMMENT = "존재하지 않는 노선 이름입니다.";

    public final static String[] SCREEN_MENU_SECTION_MANAGEMENT = {
        "## 구간 관리 화면"
        , "1. 구간 등록"
        , "2. 구간 삭제"
        , "B. 돌아가기"
    };

    public final static String ADD_SECTION_LINE_INPUT_COMMENT = "## 노선을 입력하세요.";
    public final static String ADD_SECTION_STATION_INPUT_COMMENT = "## 역이름을 입력하세요.";
    public final static String ADD_SECTION_INDEX_INPUT_COMMENT = "## 순서를 입력하세요.";
    public final static String ADD_SECTION_OUTPUT_COMMENT = "구간이 등록되었습니다.";
    public final static String DELETE_SECTION_LINE_INPUT_COMMENT = "## 삭제할 구간의 노선을 입력하세요.";
    public final static String DELETE_SECTION_STATION_INPUT_COMMENT = "## 삭제할 구간의 역을 입력하세요.";
    public final static String DELETE_SECTION_OUTPUT_COMMENT = "구간이 삭제되었습니다.";

    public final static String TITLE_WHOLE_SUBWAY_MAP_TEXT = "## 지하철 노선도";
    public final static String SEPARATE_STRING_WHOLE_SUBWAY_MAP_TEXT = "---";

}
