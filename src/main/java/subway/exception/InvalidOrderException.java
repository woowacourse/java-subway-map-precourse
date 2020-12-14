package subway.exception;

public class InvalidOrderException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 순서를 확인하고 다시 입력하세요.";

    public InvalidOrderException() {
        super(ERROR_MESSAGE);
    }
}
