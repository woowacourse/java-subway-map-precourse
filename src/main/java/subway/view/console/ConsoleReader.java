package subway.view.console;

import java.util.Scanner;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public final class ConsoleReader {
    Scanner scanner = new Scanner(System.in);

    public String enterMessage() {
        return Validator.validate(scanner.nextLine());
    }

    private static class Validator {
        public static String validate(String message) {
            validateBlankInput(message);
            return message;
        }

        private static void validateBlankInput(String message) {
            if (message.isBlank()) {
                throw CustomException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }
    }
}
