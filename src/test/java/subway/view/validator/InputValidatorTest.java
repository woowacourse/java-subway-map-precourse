package subway.view.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("입력 값이 null 일 경우 예외 발생")
    public void checkNull_Null_ExceptionThrown() {

        // given
        String input = null;

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(InputValidator.NULL_ERROR);
    }

    @Test
    @DisplayName("입력 값의 길이가 최소 길이 미만일 경우 예외 발생")
    public void checkRange_LessThanLowerBound_ExceptionThrown() {

        // given
        String input = "역";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(InputValidator.RANGE_ERROR);
    }
}
