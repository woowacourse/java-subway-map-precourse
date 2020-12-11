package subway.line.exception;

public class AlreadyExistLineException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 존재하는 노선입니다.";

    public AlreadyExistLineException() {
        super(MESSAGE);
    }
}
