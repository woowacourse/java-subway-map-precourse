package subway.domain.exception;

public class InvalidNameLengthException extends IllegalArgumentException {
    public InvalidNameLengthException() {
        super("적절한 길이의 이름이 아닙니다.");
    }
}
