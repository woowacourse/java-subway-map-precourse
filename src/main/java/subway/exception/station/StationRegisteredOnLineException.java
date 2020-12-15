package subway.exception.station;

import subway.view.util.Formatter;

public class StationRegisteredOnLineException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("역이 노선에 존재합니다.");

    public StationRegisteredOnLineException() {
        super(MESSAGE);
    }
}
