package subway.view;

import subway.Menu;
import subway.SubMenu;
import subway.domain.Station;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String HASH = "\n## ";
    private static final String TITLE_MESSAGE = "관리 화면";
    private static final String MENU_SELECT_SCREEN = "\n## 원하는 기능을 선택하세요.";
    private static final String BACK_SIGN = "B";
    private static final String ADD_ORDER_START_MESSAGE = "등록할 ";
    private static final String DELETE_ORDER_START_MESSAGE = "삭제할 ";
    private static final String NAME_MESSAGE = "이름을 입력하세요.";
    private static final String LIST_MESSAGE = "목록";
    private static final String INFO_TAG = "[INFO] ";

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

    public static void printAddActionMessage(String title) {
        System.out.println(HASH + ADD_ORDER_START_MESSAGE + title + NAME_MESSAGE);
    }

    public static void printDeleteActionMessage(String title) {
        System.out.println(HASH + DELETE_ORDER_START_MESSAGE + title + NAME_MESSAGE);
    }

    public static void printList(String title, List<String> stationNames) {
        printListTitle(title);
        for (int i = 0; i < stationNames.size(); i++) {
            System.out.println(INFO_TAG + stationNames.get(i));
        }
    }

    private static void printListTitle(String title) {
        System.out.println(HASH + title + LIST_MESSAGE);
    }
}
