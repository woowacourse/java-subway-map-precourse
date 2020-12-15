package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.SectionService;

public enum MainMenu {
    CONTROL_STATION("1", "역 관리", (menuKey) -> StationDisplay.loadStationMenu()),
    CONTROL_LINE("2", "노선 관리", (menuKey) -> LineDisplay.loadLineMenu()),
    CONTROL_SECTION("3", "구간 관리", (menuKey) -> SectionDisplay.loadSectionMenu()),
    PRINT_ALL_SECTIONS("4", "지하철 노선도 출력", (menuKey) -> SectionService.printSections()),
    QUIT_PROGRAM("Q", "종료", (menuKey) -> back());

    private final String menuKey;
    private final String menuName;
    private final Consumer<String> menuSelect;

    MainMenu(String menuKey, String menuName, Consumer<String> menuSelect) {
        this.menuKey = menuKey;
        this.menuName = menuName;
        this.menuSelect = menuSelect;
    }

    public static MainMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(mainMenu
            -> mainMenu.getMenuKey().equals(input))
            .findAny().get();
    }

    private static void back() {
    }

    public String getMenuKey() {
        return menuKey;
    }

    public String getMenuName() {
        return menuName;
    }

    public void executeMenu(String menuKey) {
        menuSelect.accept(menuKey);
    }
}