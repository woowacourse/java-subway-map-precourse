package subway.domain.menu.submenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.Action;
import subway.domain.menu.submenu.action.DeleteAction;
import subway.domain.menu.submenu.action.RegisterAction;
import subway.domain.menu.submenu.action.ViewAction;
import subway.view.InputView;

public class SubMenu {
    protected String category;
    protected char order;
    protected String titleActionMessage;
    protected static final char REGISTER_SEL = '1';
    protected static final char DELETE_SEL = '2';
    protected static final char VIEW_SEL = '3';
    protected static final char BACK_SEL = 'B';
    protected static final String BACK = "돌아가기";

    private List<Character> selMenu;
    private List<Action> actionList;
    InputView inputView;

    public SubMenu(char order, String category, InputView inputView) {
        this.order = order;
        this.category = category;
        this.inputView = inputView;
        makeSelMenu();
        makeActionList(inputView);
    }

    private void makeSelMenu() {
        selMenu = new ArrayList<>();
        selMenu.addAll(Arrays.asList(BACK_SEL, REGISTER_SEL, DELETE_SEL, VIEW_SEL));

        if (category.equals(CategoryType.SECTION)) {
            selMenu.remove(Character.getNumericValue(VIEW_SEL));
        }
    }

    public void makeActionList(InputView inputView) {
        actionList = new ArrayList<>();
        actionList.addAll(Arrays.asList(new RegisterAction(REGISTER_SEL, category, ActionType.REGISTER, inputView),
                new DeleteAction(DELETE_SEL, category, ActionType.DELETE, inputView),
                new ViewAction(VIEW_SEL, category, ActionType.VIEW, inputView)));

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
        char sel = requestInputSubMenu(selMenu);

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

    private char requestInputSubMenu(List<Character> selMenu) {
        return inputView.inputMenu(selMenu);
    }

}
