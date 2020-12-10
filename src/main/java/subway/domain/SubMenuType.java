package subway.domain;

import java.util.Arrays;

public enum SubMenuType implements Menu{

    ADD("1"),
    DELETE("2"),
    LIST_PRINT("3"),
    BACK("B");

    private String menuInput;

    SubMenuType(String menuInput) {
        this.menuInput = menuInput;
    }

    public static SubMenuType validateMenu(String menuInput) {
        return Arrays.stream(SubMenuType.values())
                .filter(menu -> menu.menuInput.equals(menuInput.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    };
}
