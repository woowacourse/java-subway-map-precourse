package subway.exception;

public class StationException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public StationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
