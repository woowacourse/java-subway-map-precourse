package subway.domain;

public class Constants {
    public static final String APPLICATION_QUIT = "Q";
    public static final String SUBWAY_LINEMAP_MENU = "4";
    public static final String LINE_MAIN_MENU = "## 노선 관리 화면\n1. 노선 등록\n" +
                                                    "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    public static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    public static final String INPUT_LINE_TO_ENROLL = "## 등록할 노선 이름을 입력하세요.";
    public static final String DUPLICATED_TRY_AGAIN = "[ERROR] 중복됩니다.";
    public static final String INPUT_START_STATION_TO_ENROLL = "## 등록할 노선의 상행 종점역 " +
                                                                    "이름을 입력하세요.";
    public static final String LINE_MENU = "2";
    public static final String LINE_ENROLLED = "\n[INFO] 지하철 노선이 등록되었습니다.\n";
    public static final String NOTHING_TRY_AGAIN = "[ERROR] 해당 역이 없습니다.";
    public static final String NOTHING_OR_START_END_SAME_TRY_AGAIN = "[ERROR] 해당 역이 없거나 " +
                                                                    "상행 종점, 하행 종점역이 같습니다.";
    public static final String INPUT_END_STATION_TO_ENROLL = "## 등록할 노선의 하행 종점역 " +
                                                                    "이름을 입력하세요.";
    public static final String INPUT_LINE_TO_DELETE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String NOTHING_TO_DELETE_TRY_AGAIN = "[ERROR] 삭제할 노선이 없습니다.";
    public static final String LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.\n";
    public static final String SECTION_MAIN_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\n" +
            "B. 돌아가기\n";
    public static final String INPUT_LINE = "## 노선을 입력하세요.";
    public static final String SECTION_ENROLLED = "\n[INFO] 구간이 등록되었습니다.\n";
    public static final String LINE_NOTHING_TRY_AGAIN = "[ERROR] 해당 노선이 없습니다.";
    public static final String SECTION_MENU = "3";
    public static final String INPUT_STATION = "## 역이름을 입력하세요.";
    public static final String NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN = "[ERROR] 해당 역이 없거나" +
            " 이미 노선에 등록되어 있습니다.";
    public static final String INPUT_ORDER = "## 순서를 입력하세요.";
    public static final String INDEX_OUT_OF_BOUNDS_TRY_AGAIN = "[ERROR] 인덱스가 초과되었습니다.";
    public static final String INPUT_LINE_OF_SECTION_TO_DELETE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String SECTION_DELETED = "\n[INFO] 구간이 삭제되었습니다.\n";
    public static final String INPUT_STATION_OF_SECTION_TO_ENROLL = "## 삭제할 구간의 역을 입력하세요.";
    public static final String STATION_NOTHING_OR_LINE_LENGTH_LIMIT_TRY_AGAIN = "[ERROR] " +
            "해당 역이 없거나 현재 노선의 길이가 2이하여서 삭제 할 수 없습니다.";
    public static final int LINE_MIN_LENGTH = 2;
    public static final String STATION_MAIN_MENU = "## 역 관리 화면\n1. 역 등록\n" +
            "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    public static final String INPUT_STATION_TO_ENROLL = "## 등록할 역 이름을 입력하세요.";
    public static final String STATION_ENROLLED = "\n[INFO] 지하철 역이 등록되었습니다.\n";
    public static final String INPUT_STATION_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
    public static final String STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.\n";
    public static final String STATION_MENU_NUMBER = "1";
    public static final String MAIN_MENU = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n" +
            "4. 지하철 노선도 출력\nQ. 종료\n";
    public static final String ONE = "1";
    public static final String TOW = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String INFORMATION = "[INFO] ";
    public static final String NAME_LENGTH_LIMIT_ERROR = "[ERROR] 이름은 2글자 이상입니다.";
    public static final int NAME_LENGTH_LIMIT = 2;
    public static final String LINE_LIST = "\n## 노선 목록";
    public static final String INFORMATION_BAR = "\n[INFO] ---";
    public static final String ERROR_ONLY_SINGLE_DIGIT_POSITIVE_NUMBER = "[ERROR] 한 자리 양의 정수만 가능합니다.";
    public static final int SINGLE_DIGIT_MIN = 0;
    public static final int SINGLE_DIGIT_MAX = 9;
//    public static final String NAME_LENGTH_LIMIT_ERROR = "[ERROR] 이름은 2글자 이상입니다.";
//    public static final int NAME_LENGTH_LIMIT = 2;
    public static final String STATION_LIST = "\n## 역 목록\n";
}
