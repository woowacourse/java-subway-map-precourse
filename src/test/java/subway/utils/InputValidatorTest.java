package subway.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 메뉴_선택_입력값_테스트() {
        // given, when
        String input = "2";
        int range = 1;

        // then
        assertThrows(Exception.class, () -> {
            InputValidator.validateMenuInput(input, range);
        });
    }

    @Test
    void 입력값이_두_글자_이하_예외처리_테스트() {
        // given, when
        String positiveName = "강남역";
        String negativeName = "강역";

        // then
        assertDoesNotThrow(() -> {
            InputValidator.validateMoreThanTwoWords(positiveName);
        });

        assertThrows(Exception.class, () -> {
            InputValidator.validateMoreThanTwoWords(negativeName);
        });
    }

    @Test
    void 입력값_음수_예외처리_테스트() {
        // given, when
        int positiveNumber = 1;
        int negativeNumber = -1;

        // then
        assertDoesNotThrow(() -> {
            InputValidator.validatePositiveNumber(positiveNumber);
        });

        assertThrows(Exception.class, () -> {
            InputValidator.validatePositiveNumber(negativeNumber);
        });
    }

}