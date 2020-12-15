package subway.exception.station;

import subway.view.util.Formatter;

public class StationNotFoundException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("역을 찾을 수 없습니다.");

    public StationNotFoundException() {
        super(MESSAGE);
    }
}
