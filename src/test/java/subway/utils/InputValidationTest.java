package subway.utils;

import org.junit.jupiter.api.Test;
import subway.domain.MenuType;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidationTest {

    @Test
    public void 입력값이_선택_가능한_기능인지_검증한다() throws Exception {
        //given
        String menu1 = "1";
        String menuQ = "Q";
        String menuB = "B";

        //when
        boolean isContains1 = MenuType.MAIN_MENU_RANGE.getKeys().contains(menu1);
        boolean isContainsQ = MenuType.MAIN_MENU_RANGE.getKeys().contains(menuQ);
        boolean isContainsB = MenuType.MAIN_MENU_RANGE.getKeys().contains(menuB);

        //then
        assertThat(isContains1).isTrue();
        assertThat(isContainsQ).isTrue();
        assertThat(isContainsB).isFalse();
    }
}