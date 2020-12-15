package subway.domain.menu.submenu.action;

import subway.domain.menu.constant.CommonMessage;
import subway.view.InputView;

public class Action {
    protected char order;
    protected String category;
    protected String actionType;
    protected InputView inputView;

    public Action(char order, String category, String actionType, InputView inputView) {
        this.order = order;
        this.category = category;
        this.actionType = actionType;
        this.inputView = inputView;
    }

    public char getOrder() {
        return order;
    }

    public String getActionMessage() {
        String actionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                + actionType;

        return actionMessage;
    }

    public void runAction() {
    }
}
