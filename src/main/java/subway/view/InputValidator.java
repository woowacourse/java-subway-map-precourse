package subway.view;

import java.util.regex.Pattern;
import subway.domain.selector.menu.Menu;

public class InputValidator {

    private static final String INVALID_SELECTOR_ID_ERROR = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String SPECIAL_CHARACTER_PATTERN = "[0-9|a-z |A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝 ]*";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "[ERROR] 이름에 특수문자가 포함 되어있습니다.";

    public static void validateContainSpecialCharacters(String name) {
        if (!Pattern.matches(SPECIAL_CHARACTER_PATTERN, name)) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    public void validateSelectorId(Menu menu, String Id) {
        if (menu.getMenus().get(Id) == null && menu.getItems().get(Id) == null) {
            throw new IllegalArgumentException(INVALID_SELECTOR_ID_ERROR);
        }
    }

}
