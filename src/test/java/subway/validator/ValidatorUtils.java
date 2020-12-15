package subway.validator;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import subway.exception.SubwayRuntimeException;
import subway.exception.validator.ValidationException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidationFailure(String input, Validator validator,
                                               String message, Object... parameters) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatThrownBy(callable)
                .isInstanceOf(ValidationException.class)
                .hasMessage(SubwayRuntimeException.ERROR + message, parameters);
    }
}
