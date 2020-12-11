package subway.domain;

public enum MenuType {
    MAIN_MENU_RANGE("4"),
    MAIN_STATION("1"),
    MAIN_LINE_STATION("2"),
    MAIN_SECTION("3"),
    MAIN_PRINT_LINE_STATION( "4"),
    MAIN_QUIT("Q"),

    STATION_MENU_RANGE("3"),
    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_SEARCH("3"),

    LINE_STATION_MENU_RANGE("3"),
    LINE_STATION_ADD("1"),
    LINE_STATION_DELETE("2"),
    LINE_STATION_SEARCH("3"),

    SECTION_MENU_RANGE("2"),
    SECTION_ADD("1"),
    SECTION_DELETE("2"),
    BACK("B");

    private String key;

    MenuType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}