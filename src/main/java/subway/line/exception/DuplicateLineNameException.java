package subway.line.exception;

public class DuplicateLineNameException extends IllegalArgumentException {

    private static final String MESSAGE = "이미 존재하는 노선 이름입니다. (입력 값: '%s')";

    public DuplicateLineNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
