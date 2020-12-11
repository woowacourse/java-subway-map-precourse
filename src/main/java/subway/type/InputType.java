package subway.type;

/**
 * 기능 입력 문자 상수를 모아둔 Enum 클래스
 */
public enum InputType {
    MAIN_STATION_MANAGEMENT("1"),
    MAIN_LINE_MANAGEMENT("2"),
    MAIN_SECTION_MANAGEMENT("3"),
    MAIN_SUBWAY_MAP_PRINT("4"),
    SCREEN_QUITTING("Q");

    private final String input;

    InputType(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
