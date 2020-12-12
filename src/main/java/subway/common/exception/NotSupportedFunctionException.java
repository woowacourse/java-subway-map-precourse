package subway.common.exception;

public class NotSupportedFunctionException extends IllegalArgumentException {
    private static final String MESSAGE = "선택할 수 없는 기능입니다.";

    public NotSupportedFunctionException() {
        super(MESSAGE);
    }
}
