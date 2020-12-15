package subway.exception.line;

import subway.view.util.Formatter;

public class PositionRangeException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("위치 입력 범위가 비정상입니다.");

    public PositionRangeException() {
        super(MESSAGE);
    }
}
