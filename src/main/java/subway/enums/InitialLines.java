package subway.enums;

public enum InitialLines {
    LINE_2("2호선"),
    LINE_3("3호선"),
    LINE_SINBUNDANG("신분당선");

    private String name;

    InitialLines(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
