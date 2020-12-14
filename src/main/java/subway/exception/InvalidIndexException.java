package subway.exception;

public class InvalidIndexException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 노선 범위 내의 숫자를 입력해야 합니다. (1 ~ 2,147,483,647)";

    public InvalidIndexException() {
        super(ERROR_MESSAGE);
    }
}
