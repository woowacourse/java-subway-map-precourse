package subway.exception;

public class LineAlreadyExistsException extends RuntimeException {

    private static final String MESSAGE = "이미 존재하는 노선입니다. 다시 입력해주세요. 입력값: (%s)";

    public LineAlreadyExistsException(String name) {
        super(String.format(MESSAGE, name));
    }
}
