package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.LineService;

public enum LineMenu {
    SAVE_LINE("1", "노선 등록", (menuKey) -> LineService.saveLine()),
    DELETE_LINE("2", "노선 삭제", (menuKey) -> LineService.deleteLine()),
    PRINT_LINES("3", "노선 조회", (menuKey) -> LineService.printLines()),
    BACK_TO_MAINMENU("B", "돌아가기", (menuKey) -> back());

    private final String menuKey;
    private final String menuName;
    private final Consumer<String> menuSelect;

    LineMenu(String menuKey, String menuName, Consumer<String> menuSelect) {
        this.menuKey = menuKey;
        this.menuName = menuName;
        this.menuSelect = menuSelect;
    }

    public static LineMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(lineMenu
            -> lineMenu.getMenuKey().equals(input))
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
