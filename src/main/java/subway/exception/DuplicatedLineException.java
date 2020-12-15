package subway.exception;

public class DuplicatedLineException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 등록된 노선 이름입니다. (input: \"%s\")";

    public DuplicatedLineException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
