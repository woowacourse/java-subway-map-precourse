package subway.exception;

import subway.view.util.Formatter;

public class InvalidFunctionException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("선택할 수 없는 기능입니다.");

    public InvalidFunctionException() {
        super(MESSAGE);
    }
}
