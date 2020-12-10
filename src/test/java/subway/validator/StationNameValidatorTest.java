package subway.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationNameValidatorTest {

    private final Validator validator = new StationNameValidator();

    @Test
    @DisplayName("입력 값의 길이가 최소 길이 미만일 경우 예외 발생")
    public void checkRange_LowerThanLowerBound_ExceptionThrown() {

        // given
        String input = "역";

        // when, then
        ValidatorUtils.assertValidationFailure(input, validator, StationNameValidator.RANGE_ERROR +
                String.format(StationNameValidator.INPUT_LENGTH_MESSAGE, input.length()));
    }

    @Test
    @DisplayName("입력 값의 길이가 최대 길이 초과일 경우 예외 발생")
    public void checkRange_HigherThanLowerBound_ExceptionThrown() {

        // given
        String input = "서울특별시강남구강남역";

        // when, then
        ValidatorUtils.assertValidationFailure(input, validator, StationNameValidator.RANGE_ERROR +
                String.format(StationNameValidator.INPUT_LENGTH_MESSAGE, input.length()));
    }

    @Test
    @DisplayName("한글이 아닌 다른 문자가 입력될 경우 예외 발생")
    public void checkKorean_NotKorean_ExceptionThrown() {

        // given
        String input = "abc";

        // when, then
        ValidatorUtils
                .assertValidationFailure(input, validator, StationNameValidator.NOT_KOREAN_ERROR);
    }
}
