package subway;

public class Constants {
    public static final String MAIN_SCREEN_USER_PROMPT = "\n## 메인 화면 \n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";
    public static final String LINE_MANAGEMENT_USER_PROMPT = "\n## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기\n";
    public static final String SECTION_MANAGEMENT_USER_PROMPT = "\n## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기\n";
    public static final String STATION_MANAGEMENT_USER_PROMPT = "\n## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n";
    public static final String QUIT = "Q";
    public static final String BACK = "B";
    public static final String USER_INPUT_REGEX_START = "[1-";
    public static final String USER_INPUT_REGEX_END = "]";
    public static final int COUNT_STATION_MANAGEMENT_USER_PROMPT = 3;
    public static final int COUNT_SECTION_MANAGEMENT_USER_PROMPT = 2;
    public static final int COUNT_LINE_MANAGEMENT_USER_PROMPT = 3;
    public static final int COUNT_MAIN_USER_PROMPT = 4;
    public static final int USER_ANSWER_REGISTER = 1;
    public static final int USER_ANSWER_DELETE = 2;
    public static final int USER_ANSWER_SHOW = 3;
    public static final int USER_ANSWER_STATION_MANAGEMENT_SCREEN = 1;
    public static final int USER_ANSWER_LINE_MANAGEMENT_SCREEN = 2;
    public static final int USER_ANSWER_SECTION_MANAGEMENT_SCREEN = 3;
    public static final int USER_ANSWER_PRINT_TRANSIT_MAP = 4;
}
