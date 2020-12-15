package subway.exception.station;

import subway.view.util.Formatter;

public class StationNameLengthException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("역 이름 길이가 너무 짧습니다.");

    public StationNameLengthException() {
        super(MESSAGE);
    }
}
