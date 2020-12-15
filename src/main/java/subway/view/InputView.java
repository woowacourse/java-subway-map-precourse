package subway.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String getInput() {
        String input = scanner.nextLine();
        OutputView.printEmptyLine();
        return input;
    }

    public static void waitForEmptyInput() {
        scanner.nextLine();
    }
}
