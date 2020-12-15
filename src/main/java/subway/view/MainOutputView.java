package subway.view;

import subway.common.Prefix;

public class MainOutputView {
    private static final String MAIN_TITLE = Prefix.START.getPrefix() + "메인 화면";
    private static final String STATION_MANAGEMENT = "1. 역 관리";
    private static final String LINE_MANAGEMENT = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT = "3. 구간 관리";
    private static final String PRINT_LINE_MAP = "4. 지하철 노선도 출력";
    private static final String EXIT_SERVICE = "Q. 종료";

    private static final String ASK_OPTION_CHOICE = Prefix.START.getPrefix() + "원하는 기능을 선택하세요.";

    public static void showMainMenu() {
        System.out.println(MAIN_TITLE);
        System.out.println(STATION_MANAGEMENT);
        System.out.println(LINE_MANAGEMENT);
        System.out.println(SECTION_MANAGEMENT);
        System.out.println(PRINT_LINE_MAP);
        System.out.println(EXIT_SERVICE);
        System.out.println();
    }

    public static void askOptionChoice() {
        System.out.println(ASK_OPTION_CHOICE);
    }
}
