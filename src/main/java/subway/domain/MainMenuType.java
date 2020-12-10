package subway.domain;

import java.util.Arrays;

public enum MainMenuType {

    STATION_MANAGE("1"),
    LINE_MANAGE("2"),
    SECTION_MANAGE("3"),
    PRINT_MAP("4"),
    END_PROGRAM("Q");

    private static final String MAIN_MENU_ERROR = "[ERROR] 메뉴 선택을 잘못하셨습니다.";

    private String menuInput;

    MainMenuType(String menuInput) {
        this.menuInput = menuInput;
    }

    public static MainMenuType validateMainMenu(String mainMenuInput) {
        return Arrays.stream(MainMenuType.values())
                .filter(menu -> menu.menuInput.equals(mainMenuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    }

}
