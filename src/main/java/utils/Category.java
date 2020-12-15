package utils;

public enum Category {
    MAIN("메인"), STATION("역"), LINE("노선"), SECTION("구간");

    Category(String name) {}

    public String getName() {
        return name();
    }
}
