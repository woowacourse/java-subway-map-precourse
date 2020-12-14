package subway.console;

import static subway.console.Output.print;

import java.util.List;
import java.util.Scanner;
import subway.console.message.ErrorMessage;
import subway.console.message.InputMessage;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private static final String REGEX = "\\p{Z}";
    private static final String REPLACEMENT = "";

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextButton(List<String> buttons) {
        String button = toUpper(nextLine());
        while (!buttons.contains(button)) {
            print(ErrorMessage.NOT_BUTTON);
            print(InputMessage.SELECT_BUTTON);
            button = toUpper(nextLine());
        }
        return button;
    }

    private String toUpper(String input) {
        return input.toUpperCase();
    }

    public String nextLine() {
        return scanner.nextLine().replaceAll(REGEX, REPLACEMENT);
    }

    public boolean isNumeric(String number) {
        try {
            toInt(number);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    private void toInt(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC);
        }
    }
}
