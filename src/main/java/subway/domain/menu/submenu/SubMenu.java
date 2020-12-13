package subway.domain.menu.submenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.Action;
import subway.domain.menu.submenu.action.DeleteAction;
import subway.domain.menu.submenu.action.RegisterAction;
import subway.domain.menu.submenu.action.ViewAction;

public class SubMenu {
    protected String category;
    protected char order;
    protected String titleActionMessage;
    protected static final char REGISTER_SEL = '1';
    protected static final char DELETE_SEL = '2';
    protected static final char VIEW_SEL = '3';
    protected static final char BACK_SEL = 'B';
    protected static final String BACK = "돌아가기";
    private List<Action> actionList;
    private final Scanner scanner;

    public SubMenu(char order, String category, Scanner scanner) {
        this.order = order;
        this.category = category;
        makeActionList(scanner);
        this.scanner = scanner;
    }

    public void makeActionList(Scanner scanner) {
        actionList = new ArrayList<>();
        actionList.addAll(Arrays.asList(new RegisterAction(REGISTER_SEL, category, ActionType.REGISTER, scanner),
                new DeleteAction(DELETE_SEL, category, ActionType.DELETE, scanner),
                new ViewAction(VIEW_SEL, category, ActionType.VIEW, scanner)));

        if (category.equals(CategoryType.SECTION)) {
            actionList.remove(actionList.size() - 1);
        }
    }

    public char getOrder() {
        return order;
    }

    public String getTitle() {
        String title = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category + CommonMessage.SPACE
                + ActionType.MANAGE + CommonMessage.SPACE + CommonMessage.SCREEN;

        return title;
    }

    public String getTitleActionMessage() {
        titleActionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                + ActionType.MANAGE;

        return titleActionMessage;
    }

    public void runSubMenu() {
        printSubMenu();
        char sel = inputSubMenu();

        if (sel == BACK_SEL) {
            return;
        }

        actionList.stream().filter(menu -> menu.getOrder() == sel).findFirst().get().runAction();
    }

    public void printSubMenu() {
        System.out.println(getTitle());
        actionList.stream().forEach(menu -> System.out.println(menu.getActionMessage()));
        System.out.println(BACK_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + BACK);
        System.out.println();
    }

    private char inputSubMenu() {
        System.out.println(CommonMessage.SELECT_MESSAGE);
        char sel = scanner.nextLine().charAt(0);
        System.out.println();

        return sel;
    }

}
