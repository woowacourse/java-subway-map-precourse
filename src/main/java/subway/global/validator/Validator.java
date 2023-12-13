package subway.global.validator;

import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public final class Validator {
    public static void validateMinLength(String input, int min) {
        if (input.length() < min) {
            throw CustomException.from(ErrorMessage.INVALID_LENGTH_ERROR);
        }
    }

    public static int validateNumber(String message, ErrorMessage errorMessage) {
        if (isNotNumber(message)) {
            throw CustomException.from(errorMessage);
        }
        return Integer.parseInt(message);
    }

    public static boolean isNotNumber(String str) {
        return !str.matches("\\d+");
    }
}
