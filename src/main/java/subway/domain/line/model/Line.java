package subway.domain.line.model;

import java.util.Objects;

public class Line {
    private static final String NAME_SHORTER_THAN_MIN_LINE_NAME_LIMIT_MESSAGE = "[ERROR] 지하철 노선 이름이 2글자 이상이어야 합니다.";
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

    public boolean isEqualTo(Line line) {
        return Objects.equals(name, line.name);
    }
}
