package subway.view;

public interface ViewConstant {
    static final String STATION = "역";
    static final String LINE = "노선";
    static final String NAME = "이름";
    static final String MAIN_MENU_MESSAGE = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n" +
            "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    static final String SUB_MENU_MESSAGE_TOP = "\n## %s 관리 화면\n";
    static final String SUB_MENU_MESSAGE_ONE = "1. %s 등록\n";
    static final String SUB_MENU_MESSAGE_TWO = "2. %s 삭제\n";
    static final String SUB_MENU_MESSAGE_THREE = "3. %s 조회\n";
    static final String SUB_MENU_MESSAGE_BOTTOM = "B. 돌아가기\n";

    static final String CHOOSE_MENU_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    static final String INPUT_NAME_ADD_MESSAGE = "\n## 등록할 %s 이름을 입력하세요.\n";
    static final String INPUT_UP_OR_DOWN_LAST_STATION_MESSAGE = "\n## 등록할 노선의 %s행 종점역 이름을 입력하세요.\n";
    static final String INPUT_NAME_DELETE_MESSAGE = "\n## 삭제할 %s 이름을 입력하세요.\n";
    static final String INPUT_SECTION_ADD_MESSAGE = "\n## %s을 입력하세요.\n";
    static final String INPUT_SECTION_INDEX_MESSAGE = "\n## 순서를 입력하세요.";
    static final String INPUT_SECTION_DELETE_MESSAGE = "\n## 삭제할 구간의 %s을 입력하세요.\n";

    static final String PRINT_STATION_LIST_MESSAGE = "\n## 역 목록";
    static final String PRINT_LINE_LIST_MESSAGE = "\n## 노선 목록";
    static final String PRINT_SUBWAY_MAP_MESSAGE = "\n## 지하철 노선도";
    static final String PRINT_LIST = "[INFO] %s\n";
    static final String DASH = "---";
    static final String ADD_MESSAGE = "\n[INFO] %s이 등록되었습니다.\n";
    static final String DELETE_MESSAGE = "\n[INFO] %s이 삭제되었습니다.\n";
    static final String SUBWAY = "지하철 ";
    static final String SECTION = "구간";

}
