package subway.domain.exception;

public class UnvalidNameLengthException extends RuntimeException {
    private static final String UNVALID_NAME_LENGTH_ERROR_MESSAGE = "\n[ERROR] 이름은 2글자 이상으로 입력해야 합니다.";

    public UnvalidNameLengthException() {
        super(UNVALID_NAME_LENGTH_ERROR_MESSAGE);
    }
}
