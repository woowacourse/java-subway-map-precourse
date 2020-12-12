package subway.line.exception;

public class DuplicateStationNameInLineException extends IllegalArgumentException {

    private static final String MESSAGE = "%s 노선에 이미 존재하는 역입니다. (입력 값: '%s')";

    public DuplicateStationNameInLineException(final String lineName, final String stationName) {
        super(String.format(MESSAGE, lineName, stationName));
    }
}
