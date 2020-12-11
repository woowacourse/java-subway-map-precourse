package subway.station.exception;

public class NotExistStationException extends IllegalArgumentException {
    private static final String MESSAGE = "등록되지 않은 지하철 역입니다. ";

    public NotExistStationException() {
        super(MESSAGE);
    }
}
