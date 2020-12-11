package subway.exception;

public class LineException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public LineException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
