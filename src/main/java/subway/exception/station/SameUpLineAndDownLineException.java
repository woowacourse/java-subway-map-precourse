package subway.exception.station;

import subway.view.util.Formatter;

public class SameUpLineAndDownLineException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("하행선과 상행선이 동일합니다.");

    public SameUpLineAndDownLineException() {
        super(MESSAGE);
    }
}
