package subway.console;

interface StationScreen {
    String STATION_SCREEN_MANAGER_MENU = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    String MESSAGE_ADD_STATION_INPUT_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    String MESSAGE_STATION_ADDED = "[INFO] 지하철 역이 등록되었습니다.";
    String MESSAGE_DELETE_STATION_INPUT_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    String MESSAGE_STATION_DELETED = "[INFO] 지하철 역이 삭제되었습니다.";
    String MESSAGE_STATION_LIST = "## 역 목록";
    String[] STATION_MENU_CHOICES = {"1", "2", "3", "B"};
    String STATION_SCREEN_SELECT_ADD = STATION_MENU_CHOICES[0];
    String STATION_SCREEN_SELECT_DELETE = STATION_MENU_CHOICES[1];
    String STATION_SCREEN_SELECT_DISPLAY_ALL = STATION_MENU_CHOICES[2];
    String STATION_SCREEN_SELECT_GO_BACK = STATION_MENU_CHOICES[3];
}
