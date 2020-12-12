package subway.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    private InputView() {
    }

    public static void registerScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static String getInput() {
        return scanner.next();
    }
}
