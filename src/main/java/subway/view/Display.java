package subway.view;

public class Display {

    private static String NOTICE_PREFIX = "## ";;
    private static String INFO_PREFIX = "[INFO] ";
    private static String ERROR_PREFIX = "[ERROR] ";

    public static void printNotice(String notice) {
        printEnterLine();
        System.out.println(NOTICE_PREFIX + notice);
    }

    public static void printInformation(String information) {
        printEnterLine();
        System.out.println(INFO_PREFIX + information);
    }

    public static void printInformationList(String element){
        System.out.println(INFO_PREFIX + element);
    }

    public static void printError(String error) {
        printEnterLine();
        System.out.println(ERROR_PREFIX + error);
    }

    public static void printEnterLine() {
        System.out.println();
    }
}
