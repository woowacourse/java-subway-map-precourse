package subway.line.exception;

public class NotExistLineException extends IllegalArgumentException {
    private static final String MESSAGE = "등록되지 않은 노선입니다.";

    public NotExistLineException() {
        super(MESSAGE);
    }
}
