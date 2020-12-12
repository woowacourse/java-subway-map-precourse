package subway.section.exception;

public class InvalidOrderException extends IllegalArgumentException {
    private static final String MESSAGE = "추가하려는 구간의 순서가 허용 범위를 벗어났습니다.";

    public InvalidOrderException() {
        super(MESSAGE);
    }
}
