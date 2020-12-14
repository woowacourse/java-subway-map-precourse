package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunction() {
        printQuestion(TextCollection.SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputValue() {
        return scanner.nextLine();
    }

    public static void printQuestion(String message) {
        System.out.println();
        System.out.printf("%s %s\n", TextCollection.PREFIX, message);
    }

}
