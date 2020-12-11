package subway.domain.line;

import subway.exception.ErrorCode;
import subway.exception.LineException;

public class Line {
    private static final int MIN_SIZE = 2;
    private static final String MUST_CONTAIN_LAST = "선";
    private static final String PERMIT_CHARACTER = "^[가-힣|0-9]*$";

    private String name;

    private Line(String name) {
        this.name = name;
        validateName(name);
    }

    public static Line of(String name) {
        return new Line(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateName(String name) {
        if (name.length() < MIN_SIZE) {
            throw new LineException(ErrorCode.LINE_NAME_LENGTH_ERROR);
        }
        if (!name.endsWith(MUST_CONTAIN_LAST)) {
            throw new LineException(ErrorCode.LINE_INVALID_LAST_NAME);
        }
        if (!name.matches(PERMIT_CHARACTER)) {
            throw new LineException(ErrorCode.LINE_INVALID_CHARACTER);
        }
    }
}
