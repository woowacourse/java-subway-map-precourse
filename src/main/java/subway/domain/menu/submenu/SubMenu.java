package subway.domain.menu.submenu;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CommonMessage;

public class SubMenu {
    protected String category;
    protected char order;
    protected String titleActionMessage;

    public SubMenu(char order, String category) {
        this.order = order;
        this.category = category;
    }

    public SubMenu(String titleActionMessage, char order) {
        this.titleActionMessage = titleActionMessage;
        this.order = order;
    }

    public char getOrder() {
        return order;
    }

    public String getTitle() {
        String title = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionType.MANAGE + CommonMessage.SPACE + CommonMessage.SCREEN;

        return title;
    }

    public String getTitleActionMessage() {
        if (titleActionMessage != null) {
            return order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + titleActionMessage;
        }

        titleActionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionType.MANAGE;

        return titleActionMessage;
    }

    public void action() {
        System.out.println(getTitle());
    }

}
