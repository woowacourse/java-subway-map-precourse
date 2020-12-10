package subway.view.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("입력 값이 null 일 경우 예외 발생")
    public void validate_null_ExceptionThrown() {

        // given
        String input = null;

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(InputValidator.NULL_ERROR);
    }
}
