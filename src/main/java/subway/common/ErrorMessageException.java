package subway.common;

public class ErrorMessageException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public ErrorMessageException(String message) {
        super(ERROR_PREFIX + message);
    }

}
