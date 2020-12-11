package subway.line;

import subway.line.domain.Line;
import subway.line.exception.IllegalTypeOfNameException;
import subway.line.exception.TooShortLineNameException;
import subway.util.InputTypeValidator;

public class LineValidator {
    private LineValidator() {
    }

    public static void validateRegistration(String name) {
        validateNameLength(name);
        validateInputType(name);
    }

    private static void validateNameLength(String name) {
        if (!isAvailableName(name)) {
            throw new TooShortLineNameException();
        }
    }

    private static boolean isAvailableName(String name) {
        return name.length() >= Line.MIN_NAME_LENGTH;
    }

    private static void validateInputType(String name) {
        if (!InputTypeValidator.isKoreanOrNumeric(name)) {
            throw new IllegalTypeOfNameException();
        }
    }
}
