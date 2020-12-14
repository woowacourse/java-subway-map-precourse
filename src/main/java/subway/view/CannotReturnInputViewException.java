package subway.view;

public class CannotReturnInputViewException extends RuntimeException {
    private static final String ERROR_MESSAGE = "InputView 객체의 초기화가 필요합니다.";

    public CannotReturnInputViewException() {
        super(ERROR_MESSAGE);
    }
}
