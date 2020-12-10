package subway.station.exception;

public class CannotFindStationByNameException extends RuntimeException {

    private static final String MESSAGE = "등록되지 않은 지하철 역 입니다. (입력 값: '%s')";

    public CannotFindStationByNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
