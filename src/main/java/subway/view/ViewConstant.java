package subway.view;

public interface ViewConstant {
    String STATION = "역";
    String LINE = "노선";
    String NAME = "이름";
    String SUBWAY = "지하철 ";
    String SECTION = "구간";
    String DASH = "---";
    String MAIN_MENU_MESSAGE = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    String SUB_MENU_MESSAGE_TOP = "\n## %s 관리 화면\n";
    String SUB_MENU_MESSAGE_ONE = "1. %s 등록\n";
    String SUB_MENU_MESSAGE_TWO = "2. %s 삭제\n";
    String SUB_MENU_MESSAGE_THREE = "3. %s 조회\n";
    String SUB_MENU_MESSAGE_BOTTOM = "B. 돌아가기\n";
    String CHOOSE_MENU_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    String INPUT_NAME_ADD_MESSAGE = "\n## 등록할 %s 이름을 입력하세요.\n";
    String INPUT_UP_OR_DOWN_LAST_STATION_MESSAGE = "\n## 등록할 노선의 %s행 종점역 이름을 입력하세요.\n";
    String INPUT_NAME_DELETE_MESSAGE = "\n## 삭제할 %s 이름을 입력하세요.\n";
    String INPUT_SECTION_ADD_MESSAGE = "\n## %s을 입력하세요.\n";
    String INPUT_SECTION_INDEX_MESSAGE = "\n## 순서를 입력하세요.";
    String INPUT_SECTION_DELETE_MESSAGE = "\n## 삭제할 구간의 %s을 입력하세요.\n";
    String PRINT_LIST_MESSAGE = "\n## %s 목록\n";
    String PRINT_SUBWAY_MAP_MESSAGE = "\n## 지하철 노선도";
    String PRINT_LIST = "[INFO] %s\n";
    String ADD_MESSAGE = "\n[INFO] %s이 등록되었습니다.\n";
    String DELETE_MESSAGE = "\n[INFO] %s이 삭제되었습니다.\n";
}
