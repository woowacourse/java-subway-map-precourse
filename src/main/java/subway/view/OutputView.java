package subway.view;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s \n";
    private static final String ERROR_MESSAGE = "[ERROR] %s \n";
    private static final String PRINT_LINE_SEPARATOR = "\n";

    private OutputView() {
    }

    public static void printLineSeparator() {
        printMsg(PRINT_LINE_SEPARATOR);
    }

    public static void printErrorMsg(Exception e) {
        printfMsg(ERROR_MESSAGE, e.getMessage());
    }

    public static void printInfoMsg(String infoMsg) {
        printfMsg(INFO_MESSAGE, infoMsg);
    }

    public static void printfMsg(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg) {
        System.out.print(msg);
    }
}
