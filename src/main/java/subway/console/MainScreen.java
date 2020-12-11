package subway.console;

interface MainScreen {
    String MAIN_SCREEN_MENU = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    String[] MAIN_MENU_CHOICES = {"1", "2", "3", "4", "Q"};
    String MAIN_SCREEN_SELECT_STATION_MANAGEMENT = MAIN_MENU_CHOICES[0];
    String MAIN_SCREEN_SELECT_LINE_MANAGEMENT = MAIN_MENU_CHOICES[1];
    String MAIN_SCREEN_SELECT_SECTION_MANAGEMENT = MAIN_MENU_CHOICES[2];
    String MAIN_SCREEN_SELECT_PRINT_SUBWAY_MAP = MAIN_MENU_CHOICES[3];
    String MAIN_SCREEN_SELECT_QUIT = MAIN_MENU_CHOICES[4];
}
