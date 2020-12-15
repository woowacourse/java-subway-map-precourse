package subway.view;

import subway.domain.selector.menu.Menu;

public class InputValidator {

    private static final String INVALID_SELECTOR_ID_ERROR = "[ERROR] 유효한 기능을 선택하세요.\n";

     public void validateSelectorNumber(Menu menu, String number){
        if(menu.getMenus().get(number) == null && menu.getItems().get(number) == null)
            throw new IllegalArgumentException(INVALID_SELECTOR_ID_ERROR);
    }
}
