package subway.domain;

import java.util.Arrays;

public enum StationMenuType implements Menu{

    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_LIST_PRINT("3"),
    BACK("B");

    private String menuInput;

    StationMenuType(String menuInput) {
        this.menuInput = menuInput;
    }

    public static StationMenuType validateMenu(String menuInput) {
        return Arrays.stream(StationMenuType.values())
                .filter(menu -> menu.menuInput.equals(menuInput.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    };
}
