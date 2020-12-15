package subway.exception;

public class CannotInsertSectionException extends RuntimeException {

    private static final String MESSAGE = "이미 노선에 등록된 역입니다. 다시 입력해주세요.";

    public CannotInsertSectionException() {
        super(MESSAGE);
    }
}
