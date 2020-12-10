package subway.console;

public class Menu implements SectionMessage, StationMessage, LineMessage {
    public static String SCREEN_MAIN_MENU = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n"
        + "4. 지하철 노선도 출력\nQ. 종료\n";
    public static String SCREEN_SECTION_MANAGER_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\n"
        + "B. 돌아가기";
    public static String SCREEN_STATION_MANAGER_MENU = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n"
        + "3. 역 조회\nB. 돌아가기";
    public static String SCREEN_LINE_MANAGER_MENU = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n"
        + "3. 노선 조회\nB. 돌아가기";
    public static String MESSAGE_MENU_SELECT = "## 원하는 기능을 선택하세요.";
}