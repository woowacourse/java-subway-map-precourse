package subway.screenMessage;

public interface MainScreenMessage {
    String MAIN_SCREEN_MENU = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    String MAIN_SCREEN_PRINT_SUBWAY_MAP = "\n## 지하철 노선도";
    String[] MENU_CHOICES = {"1", "2", "3", "4", "Q"};
    String STATION_MANAGEMENT = MENU_CHOICES[0];
    String LINE_MANAGEMENT = MENU_CHOICES[1];
    String SECTION_MANAGEMENT = MENU_CHOICES[2];
    String PRINT_SUBWAY_MAP = MENU_CHOICES[3];
    String QUIT = MENU_CHOICES[4];
}
