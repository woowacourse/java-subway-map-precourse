package subway.ui;

public class MainUI {
    private final static String MAIN_TITLE = "## 메인 화면";
    private final static String MAIN_MENU_STATION = "1. 역 관리";
    private final static String MAIN_MENU_LINE = "2. 노선 관리";
    private final static String MAIN_MENU_SECTION_ = "3. 구간 관리";
    private final static String MAIN_MENU_STATION_MAP = "4. 지하철 노선도 출력";
    private final static String MAIN_MENU_QUIT = "Q. 종료\n";
    private static final String INFO = "[INFO] ";
    private static final String QUIT_MESSAGE= "지하철 노선도가 종료되었습니다.";

    public static void printScreen() {
        printMainMenu();
        CommonUI.printBeforeSelectMenu();
    }

    private static void printMainMenu() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_MENU_STATION);
        System.out.println(MAIN_MENU_LINE);
        System.out.println(MAIN_MENU_SECTION_);
        System.out.println(MAIN_MENU_STATION_MAP);
        System.out.println(MAIN_MENU_QUIT);
    }

    public static void printQuit() {
        System.out.println(INFO + QUIT_MESSAGE);
    }
}
