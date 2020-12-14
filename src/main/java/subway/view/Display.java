package subway.view;

public class Display {

    private static String NOTICE_PREFIX = "## ";;
    private static String INFO_PREFIX = "[INFO] ";
    private static String ERROR_PREFIX = "[ERROR] ";

    public static void printNotice(String notice) {
        System.out.println(NOTICE_PREFIX + notice);
    }

    public static void printInformation(String information) {
        System.out.println(INFO_PREFIX + information);
    }

    public static void printError(String error) {
        System.out.println(ERROR_PREFIX + error);
    }

    public static void printEnterLine() {
        System.out.println();
    }
}
