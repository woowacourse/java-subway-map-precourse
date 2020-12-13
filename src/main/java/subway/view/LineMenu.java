package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.LineService;

public enum LineMenu {
    SAVE_LINE("1", "노선 등록",
        (menuKey) -> LineService.save(UserInput.getSaveLineName())),
    DELETE_LINE("2", "노선 삭제",
        (menuKey) -> LineService.delete(UserInput.getDeleteLineName())),
    PRINT_LINES("3", "노선 조회",
        (menuKey) -> LineService.print()),
    BACK_TO_MAINMENU("B", "돌아가기",
        (menuKey) -> back());

    private final String menuKey;
    private final String menuName;
    private Consumer<String> menuSelect;

    LineMenu(String menuKey, String menuName, Consumer<String> menuSelect) {
        this.menuKey = menuKey;
        this.menuName = menuName;
        this.menuSelect = menuSelect;
    }

    public static LineMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(mainMenu
            -> mainMenu.getMenuKey().equals(input))
            .findAny().get();
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

    private static void back() {
    }
}
