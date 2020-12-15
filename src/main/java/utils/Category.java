package utils;

public enum Category {
    MAIN("메인"), STATION("역"), LINE("노선"), SECTION("구간");

    private String korean;

    Category(String name) {
        this.korean = name;
    }

    public String getKorean() {
        return korean;
    }
}
