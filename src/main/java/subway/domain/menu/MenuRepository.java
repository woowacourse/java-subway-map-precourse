package subway.domain.menu;

import java.util.HashMap;
import java.util.Map;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.SubwayMapApplicationController;
import subway.controller.MenuController;

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

    public static Menu getMenu(MenuType menuType) {
        return menus.get(menuType);
    }

    private static void setMainMenu() {
        Menu menu = Menu.createWithMenuItems(
            getMenuTitle(MAIN),
            new MenuItem(KEY_ONE, getMergedName(MANAGE, STATION), MenuController::callStationMenu),
            new MenuItem(KEY_TWO, getMergedName(MANAGE, LINE), MenuController::callLineMenu),
            new MenuItem(KEY_THREE, getMergedName(MANAGE, SECTION), MenuController::callSectionMenu),
            new MenuItem(KEY_FOUR, PRINT_SUBWAY_MAP, SubwayMapApplicationController::showSubwayMap),
            new MenuItem(KEY_QUIT, QUIT, SubwayMapApplicationController::Quit));

        menus.put(MenuType.MAIN, menu);
    }

    private static void setStationMenu() {
        Menu menu = Menu.createWithMenuItems(
            getMenuTitle(getMergedName(MANAGE, STATION)),
            new MenuItem(KEY_ONE, getMergedName(ADD, STATION), StationController::addStation),
            new MenuItem(KEY_TWO, getMergedName(DELETE, STATION), StationController::deleteStation),
            new MenuItem(KEY_THREE, getMergedName(SHOW, STATION), StationController::showStations),
            new MenuItem(KEY_BACK, BACK, StationController::backToMainMenu));

        menus.put(MenuType.STATION, menu);
    }

    private static void setLineMenu() {
        Menu menu = Menu.createWithMenuItems(
            getMenuTitle(getMergedName(MANAGE, LINE)),
            new MenuItem(KEY_ONE, getMergedName(ADD, LINE), LineController::addLine),
            new MenuItem(KEY_TWO, getMergedName(DELETE, LINE), LineController::deleteLine),
            new MenuItem(KEY_THREE, getMergedName(SHOW, LINE), LineController::showLines),
            new MenuItem(KEY_BACK, BACK, LineController::backToMainMenu));

        menus.put(MenuType.LINE, menu);
    }

    private static void setSectionMenu() {
        Menu menu = Menu.createWithMenuItems(
            getMenuTitle(getMergedName(MANAGE, SECTION)),
            new MenuItem(KEY_ONE, getMergedName(ADD, SECTION), SectionController::addSection),
            new MenuItem(KEY_TWO, getMergedName(DELETE, SECTION), SectionController::deleteSection),
            new MenuItem(KEY_BACK, BACK, SectionController::backToMainMenu));

        menus.put(MenuType.SECTION, menu);
    }

    private static String getMergedName(String functionFormat, String object) {
        return String.format(functionFormat, object);
    }

    private static String getMenuTitle(String object) {
        return String.format(SCREEN, object);
    }
}
