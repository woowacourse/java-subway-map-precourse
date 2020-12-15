package subway.validator;

import subway.exception.validator.ValidationException;

public class Validator {

    public void validate(final String input) {
        checkNull(input);
    }

    private void checkNull(final String input) {
        if (input == null) {
            throw new ValidationException();
        }
    }
}
