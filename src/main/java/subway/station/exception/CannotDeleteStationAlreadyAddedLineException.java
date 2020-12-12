package subway.station.exception;

public class CannotDeleteStationAlreadyAddedLineException extends RuntimeException {

    private static final String MESSAGE = "노선에 등록된 역은 삭제할 수 없습니다. (입력 값: '%s')";

    public CannotDeleteStationAlreadyAddedLineException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
