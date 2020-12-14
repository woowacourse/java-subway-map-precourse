package subway.views;

import subway.menus.LineMenu;
import subway.menus.SectionMenu;

import java.util.Arrays;

public class OutputView {

    private static final String LINE_MANAGE_PAGE = "## 노선 관리 화면";
    private static final String SECTION_MANAGE_PAGE = "## 구간 관리 화면";
    private static final String SELECT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String LINE_WRAP = "\n";

    public static void printFeatureSelectMessage() {
        System.out.println(SELECT_FEATURE_MESSAGE);
    }



    public static void printLineManagePage() {
        System.out.println(LINE_WRAP + LINE_MANAGE_PAGE);
        printLineManageMenus();
        System.out.println();
    }

    private static void printLineManageMenus() {
        Arrays.stream(LineMenu.values())
            .map(LineMenu::toString)
            .forEach(System.out::println);
    }

    public static void printSectionManagePage() {
        System.out.println(LINE_WRAP + SECTION_MANAGE_PAGE);
        printSectionManageMenus();
        System.out.println();
    }

    private static void printSectionManageMenus() {
        Arrays.stream(SectionMenu.values())
            .map(SectionMenu::toString)
            .forEach(System.out::println);
    }
}
