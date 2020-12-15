package subway.exception.line;

import subway.view.util.Formatter;

public class LineNameFormatException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("이름 포멧이 이상합니다.");

    public LineNameFormatException() {
        super(MESSAGE);
    }
}
