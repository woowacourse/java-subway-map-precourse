package subway.type;

/**
 * LineType.java : 지하철 노선 초기화용 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum  LineType {
    TWO("2호선"),
    THREE("3호선"),
    SHINBUNDANG("신분당선");

    private final String line;

    LineType(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
