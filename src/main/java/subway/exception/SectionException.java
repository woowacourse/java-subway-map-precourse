package subway.exception;

public class SectionException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public SectionException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
