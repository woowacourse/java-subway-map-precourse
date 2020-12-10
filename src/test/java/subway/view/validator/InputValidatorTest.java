package subway.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("입력 값이 null 일 경우 예외 발생")
    public void checkNull_Null_ExceptionThrown() {

        // given
        String input = null;

        // when, then
        InputValidatorUtils.assertValidationFailure(input, validator, InputValidator.NULL_ERROR);
    }

    @Test
    @DisplayName("입력 값의 길이가 최소 길이 미만일 경우 예외 발생")
    public void checkRange_LowerThanLowerBound_ExceptionThrown() {

        // given
        String input = "역";

        // when, then
        InputValidatorUtils.assertValidationFailure(input, validator, InputValidator.RANGE_ERROR);
    }

    @Test
    @DisplayName("입력 값의 길이가 최대 길이 초과일 경우 예외 발생")
    public void checkRange_HigherThanLowerBound_ExceptionThrown() {

        // given
        String input = "서울시강남구강남역";

        // when, then
        InputValidatorUtils.assertValidationFailure(input, validator, InputValidator.RANGE_ERROR);
    }

    @Test
    @DisplayName("한글이 아닌 다른 문자가 입력될 경우 예외 발생")
    public void checkKorean_NotKorean_ExceptionThrown() {

        // given
        String input = "abc";

        // when, then
        InputValidatorUtils
                .assertValidationFailure(input, validator, InputValidator.NOT_KOREAN_ERROR);
    }
}
