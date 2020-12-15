package subway.exception.line;

import subway.view.util.Formatter;

public class LineNotFoundException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("노선을 찾을 수 없습니다.");

    public LineNotFoundException() {
        super(MESSAGE);
    }
}
