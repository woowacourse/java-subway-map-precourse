package subway.view;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
        newLine();
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void printSystemMessage(String string) {
        System.out.println(SHARP_PREFIX + string);
    }

    public static void printResponseMessage(String string) {
        System.out.println(INFO_PREFIX + string);
    }

    public static void newLine() {
        System.out.println();
    }
}
