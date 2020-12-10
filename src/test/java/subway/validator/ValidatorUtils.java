package subway.validator;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidationFailure(String input, Validator validator,
                                               String message) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(message);
    }
}
