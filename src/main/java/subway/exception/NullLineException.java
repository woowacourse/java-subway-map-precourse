package subway.exception;

public class NullLineException extends IllegalArgumentException {
    private static final String MESSAGE = "해당 노선은 존재하지 않습니다. (input: \"%s\")";

    public NullLineException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
