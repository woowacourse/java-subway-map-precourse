package subway.view;

import subway.controller.Function;

public class OutputView {
    private static final String MAIN_MENU_LABEL = "## 메인 화면";
    private static final String MAIN_MENU_STATION_CARE = "1. 역 관리";
    private static final String MAIN_MENU_LINE_CARE = "2. 노선 관리";
    private static final String MAIN_MENU_AREA_CARE = "3. 구간 관리";
    private static final String MAIN_MENU_SHOW_MAP = "4. 지하철 노선도 출력";
    private static final String MAIN_MENU_QUIT = "Q. 종료";

    private static final String STATION_MENU_LABEL = "## 역 관리 화면";
    private static final String STATION_MENU_ADD = "1. 역 등록";
    private static final String STATION_MENU_DELETE = "2. 역 삭제";
    private static final String STATION_MENU_VIEW = "3. 역 조회";
    private static final String STATION_MENU_QUIT = "B. 돌아가기";

    public static final String ERROR_LABEL = "[ERROR] ";
    public static final String ERROR_NOT_NUMERIC = ERROR_LABEL + "선택할 수 없는 기능입니다.";
    public static final String ERROR_OUT_OF_RANGE = ERROR_LABEL + "선택할 수 없는 기능입니다.";

    public static void printMenu(int currentMenu) {
        if (currentMenu == Function.MAIN_MENU) {
            printMainMenu();
        }
        if (currentMenu == Function.STATION_MENU) {
            printStationMenu();
        }
    }

    private static void printMainMenu() {
        System.out.println(MAIN_MENU_LABEL);
        System.out.println(MAIN_MENU_STATION_CARE);
        System.out.println(MAIN_MENU_LINE_CARE);
        System.out.println(MAIN_MENU_AREA_CARE);
        System.out.println(MAIN_MENU_SHOW_MAP);
        System.out.println(MAIN_MENU_QUIT);

    }

    private static void printStationMenu() {
        System.out.println(STATION_MENU_LABEL);
        System.out.println(STATION_MENU_ADD);
        System.out.println(STATION_MENU_DELETE);
        System.out.println(STATION_MENU_VIEW);
        System.out.println(STATION_MENU_QUIT);
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

}
