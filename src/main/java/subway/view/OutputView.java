package subway.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String GUIDE_PREFIX = "## ";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        printMessage(ERROR_PREFIX + message);
    }

    public static void printResultMessage(String message) {
        printMessage(RESULT_PREFIX + message);
    }

    public static void printGuideMessage(String message) {
        printMessage(GUIDE_PREFIX + message);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
