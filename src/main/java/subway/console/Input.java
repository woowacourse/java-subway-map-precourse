package subway.console;

import static subway.console.Output.print;
import static subway.console.message.ErrorMessage.NOT_BUTTON;
import static subway.console.message.ErrorMessage.NUMERIC;

import java.util.List;
import java.util.Scanner;
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
        return loopValidInputButton(buttons);
    }

    private String loopValidInputButton(List<String> buttons) {
        String button = toUpper(nextLine());

        while (!buttons.contains(button)) {
            print(NOT_BUTTON.getMessage());
            print(InputMessage.SELECT_BUTTON.getMessage());
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

    public String nextInt() {
        String number = nextLine();
        isNumeric(number);
        return number;
    }

    private boolean isNumeric(String number) {
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
            throw new IllegalArgumentException(NUMERIC.getMessage());
        }
    }
}
