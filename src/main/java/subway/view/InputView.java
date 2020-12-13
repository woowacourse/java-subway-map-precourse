package subway.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputFunction() {
        printQuestion(TextCollection.SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static void printQuestion(String message) {
        System.out.printf("%s %s", TextCollection.PREFIX, message);
    }
}
