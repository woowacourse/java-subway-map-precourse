package subway.exception;

public class SubwayRuntimeException extends IllegalArgumentException {

    public static final String ERROR = "[ERROR] ";

    public SubwayRuntimeException(String message) {
        super(ERROR + message);
    }
}
