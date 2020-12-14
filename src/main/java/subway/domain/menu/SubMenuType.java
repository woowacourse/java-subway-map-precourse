package subway.domain.menu;

import java.util.Arrays;

public enum SubMenuType {
    ADD("1"),
    DELETE("2"),
    LIST_PRINT("3"),
    BACK("B");

    private static final String MAIN_MENU_ERROR = "\n[ERROR] 선택할 수 없는 기능입니다.";
    private String text;

    SubMenuType(String text) {
        this.text = text;
    }

    public static SubMenuType of(String menuInput) {
        return Arrays.stream(SubMenuType.values())
                .filter(menu -> menu.text.equals(menuInput.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    }
}
