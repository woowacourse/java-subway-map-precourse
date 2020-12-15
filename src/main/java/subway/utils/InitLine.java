package subway.utils;

public enum InitLine {
    LINE2("2호선"), LINE3("3호선"), SINBUNDANG("신분당선");

    private String name;

    InitLine(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
