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

}