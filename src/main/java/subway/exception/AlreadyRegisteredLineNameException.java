package subway.exception;

public class AlreadyRegisteredLineNameException extends RuntimeException {

    private static final String MESSAGE = "이미 등록된 노선 이름입니다. 다시 입력해주세요. 입력값: (%s)";

    public AlreadyRegisteredLineNameException(String name) {
        super(String.format(MESSAGE, name));
    }
}
