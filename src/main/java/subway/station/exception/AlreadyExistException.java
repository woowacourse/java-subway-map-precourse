package subway.station.exception;

public class AlreadyExistException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 존재하는 지하철 역입니다. ";

    public AlreadyExistException() {
        super(MESSAGE);
    }
}