package subway.domain;

public class Print {
    public static void mainMenu() {
        System.out.printf(Constant.HASH + Constant.MAIN_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.SPACE + Constant.SETTING + "%n"
                + Constant.TWO + Constant.DOT + Constant.LINE + Constant.SPACE + Constant.SETTING + "%n"
                + Constant.THREE + Constant.DOT + Constant.SECTION + Constant.SPACE + Constant.SETTING + "%n"
                + Constant.FOUR + Constant.DOT + Constant.PRINT_SUBWAY_MAP + "%n"
                + Constant.Q + Constant.DOT + Constant.QUIT + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void setting(String target) {
        System.out.printf(Constant.HASH + target + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + target + Constant.SPACE + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + target + Constant.SPACE + Constant.DELETE + "%n"
                + Constant.THREE + Constant.DOT + target + Constant.SPACE + Constant.LOOKUP + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void sectionSetting() {
        System.out.printf(Constant.HASH + Constant.SECTION + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.SECTION + Constant.SPACE + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + Constant.SECTION + Constant.SPACE + Constant.DELETE + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void subwayMap() {
        System.out.printf("%n");
    }

    public static void getNameToAddOrDelete(String target, String addOrDelete) {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", addOrDelete, target);
    }

    public static void stationList() {
        System.out.printf("%n");
    }

    public static void getStationNameToAddLine(String ascendingOrDescending) {
        System.out.printf(Constant.HASH + Constant.ENTER_END_POINT + "%n", ascendingOrDescending);
    }

    public static void addOrDeleteDoneMessage(String target, String AddOrDelete) {
        System.out.printf(Constant.INFO + Constant.DONE_MESSAGE + "%n", target, AddOrDelete);
    }

    public static void setLineToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_LINE + "%n");
    }

    public static void setStationToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_STATION + "%n");
    }

    public static void setOrderToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_ORDER + "%n");
    }

    public static void setLineToDeleteSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_TO_DELETE_SECTION + "%n", Constant.LINE);
    }

    public static void setStationToDeleteSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_TO_DELETE_SECTION + "%n", Constant.STATION);
    }

    public static void addOrDeleteSectionDoneMessage(String addOrDelete) {
        System.out.printf(Constant.INFO + Constant.SECTION_DONE_MESSAGE + "%n", addOrDelete);
    }
}
