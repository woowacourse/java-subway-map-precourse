package subway.view;

import subway.Menu;
import subway.SubMenu;

import java.util.Iterator;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String HASH = "\n## ";
    private static final String TITLE_MESSAGE = "관리 화면";
    private static final String MENU_SELECT_SCREEN = "\n## 원하는 기능을 선택하세요.";
    private static final String BACK_SIGN = "B";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printSubScreen(SubMenu menu) {
        printTitle(menu);
        printSubMenus(menu);
    }

    private static void printTitle(SubMenu menu) {
        String menuTitle = menu.menuTitle;
        if (Menu.isCategoricalMenu(menu)) {
            printCategoricalMenuTitle(menuTitle);
            return;
        }
        printNonCategoricalMenuTitle(menuTitle);
    }

    private static void printCategoricalMenuTitle(String title) {
        System.out.println(HASH + title + TITLE_MESSAGE);
    }

    private static void printNonCategoricalMenuTitle(String title) {
        System.out.println(HASH + title);
    }

    private static void printSubMenus(SubMenu menu) {
        Iterator<String> menuIter = menu.actionSign.keySet().iterator();
        while (menuIter.hasNext()) {
            String key = menuIter.next();
            String value = menu.actionSign.get(key);
            String subMenuTitle = key + ". ";
            if (key != BACK_SIGN) {
                subMenuTitle += menu.menuTitle;
            }
            subMenuTitle+= value;
            System.out.println(subMenuTitle);
        }
    }

    public static void printMenuSelectScreen() {
        System.out.println(MENU_SELECT_SCREEN);
    }
}
