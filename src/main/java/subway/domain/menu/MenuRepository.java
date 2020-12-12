package subway.domain.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuRepository {
    private static final Map<MenuType, Menu> menus = new HashMap<>();

    private static final String MAIN = "메인";
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String SECTION = "구간";

    private static final String SCREEN = "%s 화면";
    private static final String MANAGE = "%s 관리";
    private static final String ADD = "%s 등록";
    private static final String DELETE = "%s 삭제";
    private static final String SHOW = "%s 조회";

    private static final String QUIT = "종료";
    private static final String BACK = "돌아가기";
    private static final String PRINT_SUBWAY_MAP = "지하철 노선도 출력";
    
    private static final String KEY_ONE = "1";
    private static final String KEY_TWO = "2";
    private static final String KEY_THREE = "3";
    private static final String KEY_FOUR = "4";
    private static final String KEY_QUIT = "Q";
    private static final String KEY_BACK = "B";


    static {
        setMainMenu();
        setStationMenu();
        setLineMenu();
        setSectionMenu();
    }

    private static void setMainMenu() {
        Menu menu = new Menu(getMenuTitle(MAIN));
        menu.addMenuItem(new MenuItem(KEY_ONE, combination(MANAGE, STATION), null));
        menu.addMenuItem(new MenuItem(KEY_TWO, combination(MANAGE, LINE), null));
        menu.addMenuItem(new MenuItem(KEY_THREE, combination(MANAGE, SECTION), null));
        menu.addMenuItem(new MenuItem(KEY_FOUR, PRINT_SUBWAY_MAP, null));
        menu.addMenuItem(new MenuItem(KEY_QUIT, QUIT, null));

        menus.put(MenuType.MAIN, menu);
    }

    private static void setStationMenu() {
        Menu menu = new Menu(getMenuTitle(combination(MANAGE, STATION)));
        menu.addMenuItem(new MenuItem(KEY_ONE, combination(ADD, STATION), null));
        menu.addMenuItem(new MenuItem(KEY_TWO, combination(DELETE, STATION), null));
        menu.addMenuItem(new MenuItem(KEY_THREE, combination(SHOW, STATION), null));
        menu.addMenuItem(new MenuItem(KEY_BACK, BACK, null));

        menus.put(MenuType.STATION, menu);
    }

    private static void setLineMenu() {
        Menu menu = new Menu(getMenuTitle(combination(MANAGE, LINE)));
        menu.addMenuItem(new MenuItem(KEY_ONE, combination(ADD, LINE), null));
        menu.addMenuItem(new MenuItem(KEY_TWO, combination(DELETE, LINE), null));
        menu.addMenuItem(new MenuItem(KEY_THREE, combination(SHOW, LINE), null));
        menu.addMenuItem(new MenuItem(KEY_BACK, BACK, null));

        menus.put(MenuType.LINE, menu);
    }

    private static void setSectionMenu() {
        Menu menu = new Menu(getMenuTitle(combination(MANAGE, SECTION)));
        menu.addMenuItem(new MenuItem(KEY_ONE, combination(ADD, SECTION), null));
        menu.addMenuItem(new MenuItem(KEY_TWO, combination(DELETE, SECTION), null));
        menu.addMenuItem(new MenuItem(KEY_BACK, BACK, null));

        menus.put(MenuType.SECTION, menu);
    }

    private static String combination(String object, String functionFormat) {
        return String.format(object, functionFormat);
    }

    private static String getMenuTitle(String object) {
        return String.format(object, SCREEN);
    }
}
