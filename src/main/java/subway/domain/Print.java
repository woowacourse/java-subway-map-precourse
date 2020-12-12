package subway.domain;

public class Print {
    public static void mainMenu() {
        System.out.printf(Constant.HASH + Constant.MAIN_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.SETTING + "%n"
                + Constant.TWO + Constant.DOT + Constant.LINE + Constant.SETTING + "%n"
                + Constant.THREE + Constant.DOT + Constant.SECTION + Constant.SETTING + "%n"
                + Constant.FOUR + Constant.DOT + Constant.PRINT_SUBWAY_MAP + "%n"
                + Constant.Q + Constant.DOT + Constant.QUIT + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void stationSetting() {
        System.out.printf(Constant.HASH + Constant.STATION + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + Constant.STATION + Constant.DELETE + "%n"
                + Constant.THREE + Constant.DOT + Constant.STATION + Constant.LOOKUP + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void lineSetting() {
        System.out.printf(Constant.HASH + Constant.LINE + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.LINE + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + Constant.LINE + Constant.DELETE + "%n"
                + Constant.THREE + Constant.DOT + Constant.LINE + Constant.LOOKUP + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void sectionSetting() {
        System.out.printf(Constant.HASH + Constant.SECTION + Constant.SETTING_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.SECTION + Constant.ADD + "%n"
                + Constant.TWO + Constant.DOT + Constant.SECTION + Constant.DELETE + "%n"
                + Constant.B + Constant.DOT + Constant.BACK + "%n%n"
                + Constant.HASH + Constant.CHOOSE_FUNCTION + "%n"
        );
    }

    public static void subwayMap() {
        System.out.printf("%n");
    }

    public static void getStationNameToAdd() {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.ADD, Constant.STATION);
    }

    public static void getStationNameToDelete() {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.DELETE, Constant.STATION);
    }

    public static void stationList() {
        System.out.printf("%n");
    }

    public static void addStationDoneMessage() {
        System.out.printf(Constant.HASH + Constant.DONE_MESSAGE + "%n", Constant.STATION, Constant.ADD);
    }

    public static void deleteStationDoneMessage() {
        System.out.printf(Constant.HASH + Constant.DONE_MESSAGE + "%n", Constant.STATION, Constant.DELETE);
    }

    public static void getLineNameToAdd() {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.ADD, Constant.LINE);
    }

    public static void getLineNameToDelete() {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.DELETE, Constant.LINE);
    }

    public static void getAscendingNameToAddLine() {
        System.out.printf(Constant.HASH + Constant.ENTER_END_POINT + "%n", Constant.ASCENDING);
    }

    public static void getDescendingNameToAddLine() {
        System.out.printf(Constant.HASH + Constant.ENTER_END_POINT + "%n", Constant.DESCENDING);
    }

    public static void addLineDoneMessage() {
        System.out.printf(Constant.HASH + Constant.DONE_MESSAGE + "%n", Constant.LINE, Constant.ADD);
    }

    public static void deleteLineDoneMessage() {
        System.out.printf(Constant.HASH + Constant.DONE_MESSAGE + "%n", Constant.LINE, Constant.DELETE);
    }

    public static void setLineToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_LINE);
    }

    public static void setStationToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_STATION);
    }

    public static void setOrderToAddSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_ORDER);
    }

    public static void setLineToDeleteSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_TO_DELETE_SECTION, Constant.LINE);
    }

    public static void setStationToDeleteSection() {
        System.out.printf(Constant.HASH + Constant.ENTER_TO_DELETE_SECTION, Constant.STATION);
    }

    public static void addSectionDoneMessage() {
        System.out.printf(Constant.HASH + Constant.SECTION_DONE_MESSAGE, Constant.ADD);
    }

    public static void deleteSectionDoneMessage() {
        System.out.printf(Constant.HASH + Constant.SECTION_DONE_MESSAGE, Constant.DELETE);
    }
}
