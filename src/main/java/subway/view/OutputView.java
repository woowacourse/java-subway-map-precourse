package subway.view;

import subway.view.screen.Screen;

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

    public static void printResult(final String value) {
        println(Screen.INFO_PREFIX + value);
    }

    public static void printTitle(final String value) {
        println(Screen.DOUBLE_SHARP + value);
    }
}
