package subway.view;

import java.util.Scanner;

public class InputView {
    public static String getInput(Scanner scanner) {
        String userInput = scanner.nextLine();
        OutputView.printNewLine();
        return userInput;
    }
}
