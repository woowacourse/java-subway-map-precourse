package subway.exception;

public class CannotRemoveException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 입력하신 역은 삭제할 수 없습니다.";

    public CannotRemoveException() {
        super(ERROR_MESSAGE);
    }
}
