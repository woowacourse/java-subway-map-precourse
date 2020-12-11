package subway.console;

interface SectionScreen {
    String SECTION_SCREEN_MANAGER_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    String MESSAGE_ADD_SECTION_INPUT_LINE_NAME = "## 노선을 입력하세요.";
    String MESSAGE_ADD_SECTION_INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    String MESSAGE_ADD_SECTION_INPUT_STATION_INDEX = "## 순서를 입력하세요.";
    String MESSAGE_SECTION_ADDED = "[INFO] 구간이 등록되었습니다.";
    String MESSAGE_DELETE_SECTION_INPUT_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    String MESSAGE_DELETE_SECTION_INPUT_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    String MESSAGE_SECTION_DELETED = "[INFO] 구간이 삭제되었습니다.";
    String[] SECTION_MENU_CHOICES = {"1", "2", "B"};
    String SECTION_SCREEN_SELECT_ADD = SECTION_MENU_CHOICES[0];
    String SECTION_SCREEN_SELECT_DELETE = SECTION_MENU_CHOICES[1];
    String SECTION_SCREEN_SELECT_GO_BACK = SECTION_MENU_CHOICES[2];
}
