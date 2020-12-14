package subway.exception;

public class SubwayRuntimeException extends IllegalArgumentException {

    protected static final String ERROR = "[ERROR] ";

    public SubwayRuntimeException(String message) {
        super(ERROR + message);
    }
}
