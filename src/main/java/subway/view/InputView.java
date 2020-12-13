package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String PREFIX = "##";
    private static final String SELECT_FUNCTION_MESSAGE = "원하는 기능을 선택하세요.";
    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputFunction() {
        printQuestion(SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static void printQuestion(String message) {
        System.out.printf("%s %s", PREFIX, message);
    }
}
