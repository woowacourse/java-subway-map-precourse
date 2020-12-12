package subway.domain.menu.submenu.action;

import java.util.Scanner;

import subway.domain.menu.constant.CommonMessage;

public class Action {
    protected char order;
    protected String category;
    protected String actionType;
    protected Scanner scanner;

    public Action(char order, String category, String actionType, Scanner scanner) {
        this.order = order;
        this.category = category;
        this.actionType = actionType;
        this.scanner = scanner;
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
