package subway.type;

public class UnsupportedFunctionException extends RuntimeException {
    private static final String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public UnsupportedFunctionException() {
        super(ERROR_MESSAGE);
    }
}
