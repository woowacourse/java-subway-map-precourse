package subway.exception;

public class StationApplicationException extends RuntimeException {
    public StationApplicationException(RuntimeException e) {
        super(e);
    }
}
