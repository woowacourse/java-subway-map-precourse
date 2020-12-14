package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.SectionService;

public enum SectionMenu {

    SAVE_SECTION("1", "구간 등록", (menuKey) -> SectionService.insertStation()),
    DELETE_SECTION("2", "구간 삭제", (menuKey) -> SectionService.deleteStation()),
    BACK_TO_MAINMENU("B", "돌아가기", (menuKey) -> back());

    private final String menuKey;
    private final String menuName;
    private final Consumer<String> menuSelect;

    SectionMenu(String menuKey, String menuName, Consumer<String> menuSelect) {
        this.menuKey = menuKey;
        this.menuName = menuName;
        this.menuSelect = menuSelect;
    }

    public static SectionMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(sectionMenu -> sectionMenu.getMenuKey().equals(input))
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
