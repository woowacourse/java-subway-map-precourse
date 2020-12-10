package subway.station.exception;

public class DuplicateStationNameException extends IllegalArgumentException {

    private static final String MESSAGE = "이미 존재하는 역 이름입니다. (입력 값: '%s')";

    public DuplicateStationNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
