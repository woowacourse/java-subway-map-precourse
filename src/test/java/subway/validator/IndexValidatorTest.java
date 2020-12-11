package subway.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class IndexValidatorTest {

    private final Validator validator = new IndexValidator();

    @Test
    @DisplayName("입력 값이 숫자가 아닐 경우 예외 발생")
    public void checkNumeric_NotNumeric_ExceptionThrown() {

        // given
        String notNumeric = "가나다";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(notNumeric);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(IndexValidator.NOT_NUMERIC_ERROR);
    }
}
