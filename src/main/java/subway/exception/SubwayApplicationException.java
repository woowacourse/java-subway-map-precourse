package subway.exception;

public class SubwayApplicationException extends RuntimeException {
    public SubwayApplicationException(RuntimeException e) {
        super(e);
    }
}
