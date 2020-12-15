package subway.domain.menu;

public enum DataList {
    STATION("역"), LINE("노선"), SECTION("구간"), MAP("지하철 노선도");

    final private String name;

    DataList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
