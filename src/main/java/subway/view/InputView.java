package subway.view;

import java.util.Scanner;

import static subway.view.OutputView.printQuestion;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunction() {
        printQuestion(TextCollection.SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputValue() {
        return scanner.nextLine();
    }
}
