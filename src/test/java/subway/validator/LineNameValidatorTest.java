package subway.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.domain.LineName;
import subway.exception.validator.LineNameOutOfRangeException;

class LineNameValidatorTest {

    private final Validator validator = new LineNameValidator();

    @Test
    @DisplayName("입력 값의 길이가 최소 길이 미만일 경우 예외 발생")
    public void checkRange_LowerThanLowerBound_ExceptionThrown() {

        // given
        String input = "선";

        // when, then
        ValidatorUtils
                .assertValidationFailure(input, validator, LineNameOutOfRangeException.LENGTH_ERROR,
                        LineName.LENGTH_LOWER_BOUND, LineName.LENGTH_UPPER_BOUND, input.length());
    }

    @Test
    @DisplayName("입력 값의 길이가 최대 길이 초과일 경우 예외 발생")
    public void checkRange_HigherThanLowerBound_ExceptionThrown() {

        // given
        String input = "서울특별시강남구강남선";

        // when, then
        ValidatorUtils
                .assertValidationFailure(input, validator, LineNameOutOfRangeException.LENGTH_ERROR,
                        LineName.LENGTH_LOWER_BOUND, LineName.LENGTH_UPPER_BOUND, input.length());
    }

    @Test
    @DisplayName("한글과 숫자가 아닌 다른 문자가 입력될 경우 예외 발생")
    public void checkKorean_NotKorean_ExceptionThrown() {

        // given
        String input = "a선";

        // when, then
        ValidatorUtils.assertValidationFailure(input, validator,
                LineNameValidator.NOT_KOREAN_OR_NUMBER_ERROR);
    }
}