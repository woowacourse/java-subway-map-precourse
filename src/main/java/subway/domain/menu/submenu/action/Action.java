package subway.domain.menu.submenu.action;

import subway.domain.menu.constant.CommonMessage;

public class Action {
    protected char order;
    protected String category;
    protected String actionType;

    public Action(char order, String category, String actionType) {
        this.order = order;
        this.category = category;
        this.actionType = actionType;
    }

    public String getActionMessage() {
        String actionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                + actionType;

        return actionMessage;
    }
}
