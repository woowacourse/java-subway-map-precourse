package subway.console;

interface LineScreen {
    String LINE_SCREEN_MANAGER_MENU = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    String MESSAGE_ADD_LINE_INPUT_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_ADDED = "[INFO] 지하철 노선이 등록되었습니다.";
    String MESSAGE_DELETE_LINE_INPUT_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_DELETED = "[INFO] 지하철 노선이 삭제되었습니다.";
    String MESSAGE_STATION_LIST = "## 노선 목록";
    String[] LINE_MENU_CHOICES = {"1", "2", "3", "B"};
    String LINE_SCREEN_SELECT_ADD = LINE_MENU_CHOICES[0];
    String LINE_SCREEN_SELECT_DELETE = LINE_MENU_CHOICES[1];
    String LINE_SCREEN_SELECT_DISPLAY_ALL = LINE_MENU_CHOICES[2];
    String LINE_SCREEN_SELECT_GO_BACK = LINE_MENU_CHOICES[3];
}
