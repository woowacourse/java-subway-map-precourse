package subway.domain.menu.submenu;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CommonMessage;

public class SubMenu {
    protected String category;
    protected char order;
    protected String actionMessage;

    public SubMenu(char order, String category) {
        this.order = order;
        this.category = category;
    }

    public SubMenu(String actionMessage, char order) {
        this.actionMessage = actionMessage;
        this.order = order;
    }

    public String getTitle() {
        String title = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionType.MANAGE + CommonMessage.SPACE + CommonMessage.SCREEN;

        return title;
    }

}
