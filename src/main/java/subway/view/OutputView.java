package subway.view;

import subway.domain.screen.MainScreen;
import subway.domain.screen.Screen;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR]";
    private final static String INFO_PREFIX = "[INFO]";
    private final static String SPACE = " ";

    public static void showMainScreen() {
        String message = MainScreen.getInstance().getMessage();
        printGuide(message);
    }

    private static void printGuide(String message) {
        println(message);
    }

    private void printError(String message) {
        println(ERROR_PREFIX + SPACE + message);
    }

    private void printInfo(String message) {
        println(INFO_PREFIX + SPACE + message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
