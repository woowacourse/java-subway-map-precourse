package subway.domain;

import java.util.Arrays;
import java.util.List;

public enum MenuType {
    MAIN_MENU_RANGE(Arrays.asList("1", "2", "3", "4", "Q")),
    MAIN_STATION("1"),
    MAIN_LINE_STATION("2"),
    MAIN_SECTION("3"),
    MAIN_PRINT_LINE_STATION( "4"),
    MAIN_QUIT("Q"),

    STATION_MENU_RANGE(Arrays.asList("1", "2", "3", "B")),
    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_SEARCH("3"),

    LINE_STATION_MENU_RANGE(Arrays.asList("1", "2", "3", "B")),
    LINE_STATION_ADD("1"),
    LINE_STATION_DELETE("2"),
    LINE_STATION_SEARCH("3"),

    SECTION_MENU_RANGE(Arrays.asList("1", "2", "B")),
    SECTION_ADD("1"),
    SECTION_DELETE("2");

    private String key;
    private List<String> keys;

    MenuType(String key) {
        this.key = key;
    }

    MenuType(List<String> keys) {
        this.keys = keys;
    }

    public List<String> getKeys() {
        return keys;
    }

    public boolean isKeyEquals(String menu) {
        return this.key.equals(menu);
    }
}