package subway.exception;

public class NoSuchIdentifierException extends FunctionException {

    public static final String NOT_SELECTABLE_ERROR = "선택할 수 없는 기능입니다.";

    public NoSuchIdentifierException() {
        super(NOT_SELECTABLE_ERROR);
    }
}
