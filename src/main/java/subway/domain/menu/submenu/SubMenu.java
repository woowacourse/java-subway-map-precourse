package subway.domain.menu.submenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;

public class SubMenu {
    protected String category;
    protected char order;
    protected String titleActionMessage;
    protected static final char REGISTER_SEL = '1';
    protected static final char DELETE_SEL = '2';
    protected static final char VIEW_SEL = '3';
    protected static final char BACK_SEL = 'B';
    protected static final String BACK = "돌아가기";
    private static final int REMOVE_ITEM = 2;
    protected List<String> selMenuList;
    private final Scanner scanner;

    public SubMenu(char order, String category, Scanner scanner) {
        this.order = order;
        this.category = category;
        selMenuList = new ArrayList<>();
        createSelMenuList();
        this.scanner = scanner;
    }

    public void createSelMenuList() {
        selMenuList.addAll(Arrays.asList(
                (REGISTER_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                        + ActionType.REGISTER),
                (DELETE_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                        + ActionType.DELETE),
                (VIEW_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE
                        + ActionType.VIEW),
                (BACK_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + BACK)));

        if (category.equals(CategoryType.SECTION)) {
            selMenuList.remove(REMOVE_ITEM);
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
    }

    public void printSubMenu() {
        System.out.println();
        System.out.println(getTitle());
        selMenuList.stream().forEach(menu -> System.out.println(menu));
        System.out.println();
    }

    private char inputSubMenu() {
        System.out.println(CommonMessage.SELECT_MESSAGE);
        char sel = scanner.nextLine().charAt(0);

        return sel;
    }

}
