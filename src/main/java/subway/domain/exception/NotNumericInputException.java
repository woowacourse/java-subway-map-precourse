package subway.domain.exception;

public class NotNumericInputException extends IllegalArgumentException {
    public NotNumericInputException() {
        super("정수 범위의 숫자를 입력해주세요.");
    }
}
