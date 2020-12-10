package subway.view;

public final class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void println(final String value) {
        System.out.println(value);
    }

    public static void println() {
        System.out.println();
    }
}
