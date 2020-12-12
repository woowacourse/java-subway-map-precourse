package subway;

public class Constant {
    public static final int MIN_STATION_NAME_LENGTH = 2;
    public static final int MIN_LINE_LENGTH = 2;
    public static final String FIRST_COMMAND = "1";
    public static final String SECOND_COMMAND = "2";
    public static final String THIRD_COMMAND = "3";
    public static final String FORTH_COMMAND = "4";
    public static final String QUIT_COMMAND = "Q";
    public static final String BACK_COMMAND = "B";
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String INFO_PREFIX = "[INFO]";
    public static final String MAIN_ANNOUNCEMENT = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    public static final String STATION_ANNOUNCEMENT = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    public static final String LINE_ANNOUNCEMENT = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    public static final String SECTION_ANNOUNCEMENT = "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n";
    public static final String INPUT_ANNOUNCEMENT = "## 원하는 기능을 선택하세요.\n";
    public static final String DUPLICATE_STATION_NAME = "이미 등록된 역 이름입니다.\n";

}
