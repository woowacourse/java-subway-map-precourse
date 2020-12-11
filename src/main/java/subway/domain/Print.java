package subway.domain;

public class Print {
    public static void mainMenu() {
        System.out.printf(Constant.HASH + Constant.MAIN_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.SETTING + "%n"
                + Constant.TWO + Constant.DOT + Constant.LINE + Constant.SETTING + "%n"
                + Constant.THREE + Constant.DOT + Constant.SECTION + Constant.SETTING + "%n"
                + Constant.FOUR + Constant.DOT + Constant.PRINT_SUBWAY_MAP + "%n"
                + Constant.Q + Constant.DOT + Constant.QUIT + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION
        );
    }

    public static void stationSetting() {
        System.out.printf(Constant.HASH + Constant.STATION + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + Constant.STATION + Constant.DELETE + "%n"
                + Constant.THREE + Constant.DOT + Constant.STATION + Constant.LOOKUP + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION
        );
    }

    public static void getStationName() {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.ADD, Constant.STATION);
    }
}
