package subway.exception.station;

import subway.view.util.Formatter;

public class StationNameFormatException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("역 이름 혁식이 맞지 않습니다.");

    public StationNameFormatException() {
        super(MESSAGE);
    }
}
