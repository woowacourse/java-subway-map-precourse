package subway.views;

public class SystemOutput {
    static final String INFO = SystemMessages.INFO;

    public static void printMainMessage() {
        System.out.println(SystemMessages.MAIN_VIEW_MESSAGE);
        for (String option : SystemMessages.MAIN_CONTROL_MESSAGE) {
            System.out.println(option);
        }
        selectMessage();
    }

    public static void selectMessage() {
        System.out.println();
        System.out.println(SystemMessages.SELECT_OPTION_MESSAGE);
    }

    public static void printStationMessage() {
        System.out.println(SystemMessages.STATION_VIEW_MESSAGE);
        for (String option : SystemMessages.STATION_CONTROL_MESSAGE) {
            System.out.println(option);
        }
        selectMessage();
    }

    public static void printLineMessage() {
        System.out.println(SystemMessages.LINE_VIEW_MESSAGE);
        for (String option : SystemMessages.LINE_CONTROL_MESSAGE) {
            System.out.println(option);
        }
        selectMessage();
    }

    public static void printSectionMessage() {
        System.out.println(SystemMessages.SECTION_VIEW_MESSAGE);
        for (String option : SystemMessages.SECTION_CONTROL_MESSAGE) {
            System.out.println(option);
        }
        selectMessage();
    }

    public static void printList(String[] list) {
        for (String element : list) {
            System.out.println(INFO + element);
        }
    }

    public static void printSubwayMap(String Line, String[] stations) {
        System.out.println(INFO + Line);
        System.out.println(INFO + SystemMessages.DIVIDE);
        for (String station : stations) {
            System.out.println(INFO + station);
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInfo(String message) {
        System.out.println(INFO + message);
    }
}
