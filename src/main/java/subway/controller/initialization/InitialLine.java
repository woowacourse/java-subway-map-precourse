package subway.controller.initialization;

public enum InitialLine {
    LINE_NUMBER_2("2호선"),
    LINE_NUMBER_3("3호선"),
    SHINBUNDANG_LINE("신분당선");

    private String name;

    InitialLine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
