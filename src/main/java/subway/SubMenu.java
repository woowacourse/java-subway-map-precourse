package subway;

import java.util.Map;

public class SubMenu {
    public final String menuTitle;
    public final Map<String, String> actionSign;

    public SubMenu(Map<String, String> actionSign) {
        this.menuTitle = actionSign.get(Menu.MENU_TITLE_SIGN);
        actionSign.remove(Menu.MENU_TITLE_SIGN);
        this.actionSign = actionSign;
    }
}
