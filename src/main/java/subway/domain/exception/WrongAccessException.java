package subway.domain.exception;

public class WrongAccessException extends IllegalArgumentException {
    public WrongAccessException() {
        super("잘못된 접근입니다.");
    }
}
