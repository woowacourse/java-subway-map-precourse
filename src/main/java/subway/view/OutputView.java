package subway.view;

import subway.Menu;
import subway.SubMenu;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    private static final String MAIN_SCREEN = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String HASH = "\n## ";
    private static final String TITLE_MESSAGE = "관리 화면";
    private static final String MENU_SELECT_SCREEN = "\n## 원하는 기능을 선택하세요.";
    private static final String BACK_SIGN = "B";
    private static final String ADD_ORDER_START_MESSAGE = "등록할 ";
    private static final String DELETE_ORDER_START_MESSAGE = "삭제할 ";
    private static final String NAME_MESSAGE = "이름";
    private static final String INPUT_MESSAGE = "을 입력하세요.";
    private static final String LIST_MESSAGE = "목록";
    private static final String INFO_TAG = "[INFO] ";
    private static final String SUBWAY_MESSAGE = "지하철 ";
    private static final String ADD_FINISH_MESSAGE = "이 등록되었습니다.";
    private static final String DELETE_FINISH_MESSAGE = "이 삭제되었습니다.";
    private static final String ADD_LINE_BOUND_START_MESSAGE = "등록할 노선의 ";
    private static final String UPBOUND = "상행 종점역 ";
    private static final String DOWNBOUND = "하행 종점역 ";
    private static final String ORDER_INPUT_MESSAGE = "순서를 입력하세요.";
    private static final String EDGE_MESSAGE = "구간의 ";
    private static final String LINE_MAP_MESSAGE = "노선도";

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
        System.out.println(HASH + ADD_ORDER_START_MESSAGE + title + NAME_MESSAGE + INPUT_MESSAGE);
    }

    public static void printDeleteActionMessage(String title) {
        System.out.println(HASH + DELETE_ORDER_START_MESSAGE + title + NAME_MESSAGE + INPUT_MESSAGE);
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

    public static void printAddActionFinishMessage(String title) {
        System.out.println();
        System.out.println(INFO_TAG + SUBWAY_MESSAGE + title.trim() + ADD_FINISH_MESSAGE);
    }

    public static void printDeleteActionFinishMessage(String title) {
        System.out.println();
        System.out.println(INFO_TAG + SUBWAY_MESSAGE + title.trim() + DELETE_FINISH_MESSAGE);
    }

    public static void printEdgeAddActionFinishMessage(String title) {
        System.out.println();
        System.out.println(INFO_TAG + title + ADD_FINISH_MESSAGE);
    }

    public static void printEdgeDeleteActionFinishMessage(String title) {
        System.out.println();
        System.out.println(INFO_TAG + title + DELETE_FINISH_MESSAGE);
    }

    public static void printUpBoundStationMessage() {
        System.out.println(HASH + ADD_LINE_BOUND_START_MESSAGE + UPBOUND + NAME_MESSAGE +INPUT_MESSAGE);
    }

    public static void printDownBoundStationMessage() {
        System.out.println(HASH + ADD_LINE_BOUND_START_MESSAGE + DOWNBOUND + NAME_MESSAGE + INPUT_MESSAGE);
    }

    public static void printInputMessage(String title) {
        System.out.println(HASH + title + INPUT_MESSAGE);
    }

    public static void printOrderInputMessage() {
        System.out.println(HASH + ORDER_INPUT_MESSAGE);
    }

    public static void printDeleteEdgeOptionMessage(String target) {
        System.out.println(HASH + DELETE_ORDER_START_MESSAGE + EDGE_MESSAGE + target + INPUT_MESSAGE);
    }

    public static void printLineMapTitle() {
        System.out.println(HASH + SUBWAY_MESSAGE + LINE_MAP_MESSAGE);
    }

    public static void printLineMapElement(String element) {
        System.out.println(INFO_TAG + element);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
