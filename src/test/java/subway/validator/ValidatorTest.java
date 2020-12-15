package subway.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.exception.validator.ValidationException;

public class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    @DisplayName("입력 값이 null 일 경우 예외 발생")
    public void checkNull_Null_ExceptionThrown() {

        // given
        String input = null;

        // when, then
        ValidatorUtils.assertValidationFailure(input, validator, ValidationException.NULL_ERROR);
    }
}
