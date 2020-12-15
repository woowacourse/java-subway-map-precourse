package subway.exception;

public class UnregisteredSectionException extends RuntimeException {

    private static final String MESSAGE = "노선에 등록되지 않은 역입니다. 다시 입력해주세요.";

    public UnregisteredSectionException() {
        super(MESSAGE);
    }
}
