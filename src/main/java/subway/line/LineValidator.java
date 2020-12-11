package subway.line;

import subway.line.domain.Line;
import subway.line.exception.TooShortLineNameException;

public class LineValidator {
    private LineValidator() {
    }

    public static void validateRegistration(String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (!isAvailableName(name)) {
            throw new TooShortLineNameException();
        }
    }

    private static boolean isAvailableName(String name) {
        return name.length() >= Line.MIN_NAME_LENGTH;
    }
}
