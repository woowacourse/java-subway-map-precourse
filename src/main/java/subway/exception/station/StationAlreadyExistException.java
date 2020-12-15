package subway.exception.station;

import subway.view.util.Formatter;

public class StationAlreadyExistException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("역이 이미 존재합니다.");

    public StationAlreadyExistException() {
        super(MESSAGE);
    }
}
