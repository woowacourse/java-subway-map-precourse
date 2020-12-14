package subway.domain.exception;

public class InvalidOrderException extends IllegalArgumentException {
    public InvalidOrderException() {
        super("유효하지 않은 순서 입력입니다.");
    }
}
