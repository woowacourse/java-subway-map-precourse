package subway.station.exception;

public class AlreadyExistStationException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 존재하는 지하철 역입니다. ";

    public AlreadyExistStationException() {
        super(MESSAGE);
    }
}