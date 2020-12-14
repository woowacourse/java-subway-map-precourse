package subway.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import subway.exception.SubwayRuntimeException;
import subway.exception.function.RangeIndexOutOfBoundsException;
import subway.exception.validator.NotNumberException;

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
        assertThatThrownBy(callable).isExactlyInstanceOf(NotNumberException.class)
                .hasMessage(SubwayRuntimeException.ERROR +
                        NotNumberException.NOT_NUMBER_ERROR);
    }

    @Test
    @DisplayName("입력 값이 순서 최소값보다 작을 경우 예외 발생")
    public void checkIndex_LowerThanMinimum_ExceptionThrown() {

        // given
        String index = "-1";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(index);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(RangeIndexOutOfBoundsException.class)
                .hasMessage(SubwayRuntimeException.ERROR +
                        RangeIndexOutOfBoundsException.LOWER_THAN_MINIMUM_ERROR);
    }
}
