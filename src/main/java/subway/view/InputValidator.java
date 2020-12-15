package subway.view;

import subway.domain.selector.menu.Menu;

public class InputValidator {

    private static final String INVALID_SELECTOR_ID_ERROR = "[ERROR] 선택할 수 없는 기능입니다.";

    public void validateSelectorId(Menu menu, String Id) {
        if (menu.getMenus().get(Id) == null && menu.getItems().get(Id) == null) {
            throw new IllegalArgumentException(INVALID_SELECTOR_ID_ERROR);
        }
    }
}
