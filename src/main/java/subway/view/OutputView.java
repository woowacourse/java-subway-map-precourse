package subway.view;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void warnMessage(String warnMessage) {
        System.out.println(ERROR_PREFIX + warnMessage);
    }

    public static void askMessage(String askMessage) {
        System.out.println(SHARP_PREFIX + askMessage);
    }
}
