package subway.domain.validator;

import subway.domain.exception.InvalidNameLengthException;

public class NameValidator {
    private NameValidator() {
    }

    public static void checkIsValidLength(String name, int minimum) {
        if (name.length() < minimum) {
            throw new InvalidNameLengthException();
        }
    }
}
