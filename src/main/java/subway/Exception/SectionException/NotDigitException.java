package subway.Exception.SectionException;

public class NotDigitException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 숫자만 입력 가능합니다.(음수불가)";

    public NotDigitException() {
        super(MESSAGE);
    }
}
