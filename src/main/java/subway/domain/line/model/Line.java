package subway.domain.line.model;

public class Line {
    public static final String NAME_SHORTER_THAN_MIN_LINE_NAME_LIMIT_MESSAGE = "[ERROR] 지하철 역 이름이 2글자 이상이어야 합니다.";
    private static final int MIN_LINE_NAME_LIMIT = 2;

    private String name;

    public Line(String name) {
        validateLine(name);
        this.name = name;
    }

    private void validateLine(String name) {
        if (name.length() < MIN_LINE_NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_SHORTER_THAN_MIN_LINE_NAME_LIMIT_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
