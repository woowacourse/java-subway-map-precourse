package subway.ui;

import java.util.Scanner;
import subway.message.ErrorMessage;

public class ConsoleInput {

    private ConsoleInput() {
    }

    public static String scanLine(final Scanner scanner) throws IllegalArgumentException {
        final String lineInput = scanner.nextLine();
        validateLineInputNotEmpty(lineInput);
        return lineInput;
    }

    private static void validateLineInputNotEmpty(final String lineInput) {
        if (lineInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY_STRING.toString());
        }
    }
}
