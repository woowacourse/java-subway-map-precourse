package subway.domain;

import java.util.Map;

public class Menu {
    public final String menuTitle;
    public final Map<String, String> actionSign;

    public Menu(Map<String, String> actionSign) {
        this.menuTitle = actionSign.get(MenuRepository.MENU_TITLE_SIGN);
        actionSign.remove(MenuRepository.MENU_TITLE_SIGN);
        this.actionSign = actionSign;
    }
}
