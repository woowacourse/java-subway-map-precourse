package subway.exception;

public class BlankNameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "이름은 공백일 수 없습니다.";

    public BlankNameException() {
        super(ERROR_MESSAGE);
    }
}
