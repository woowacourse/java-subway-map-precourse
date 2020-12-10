package subway.view.validator;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorUtils {

    private InputValidatorUtils() {}

    public static void assertValidationFailure(String input, InputValidator validator,
                                               String message) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(message);
    }
}
