package subway.domain.exception;

public class ExistentNameException extends RuntimeException {
    private static final String EXISTENT_NAME_ERROR_MESSAGE = "\n[ERROR] 이미 등록된 역 이름입니다.";

    public ExistentNameException() {
        super(EXISTENT_NAME_ERROR_MESSAGE);
    }
}
