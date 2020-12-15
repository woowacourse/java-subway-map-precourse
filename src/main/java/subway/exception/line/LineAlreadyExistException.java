package subway.exception.line;

import subway.view.util.Formatter;

public class LineAlreadyExistException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("노선이 이미 존재합니다.");

    public LineAlreadyExistException() {
        super(MESSAGE);
    }
}
