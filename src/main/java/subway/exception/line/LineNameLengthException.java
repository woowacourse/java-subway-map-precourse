package subway.exception.line;

import subway.view.util.Formatter;

public class LineNameLengthException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("노선이 이름의 길이는 2자 이상입니다.");

    public LineNameLengthException() {
        super(MESSAGE);
    }
}