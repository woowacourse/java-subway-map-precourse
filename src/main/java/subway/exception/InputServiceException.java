package subway.exception;

public class InputServiceException extends RuntimeException {
    private final ErrorCode errorCode;

    public InputServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
