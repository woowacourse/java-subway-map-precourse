package subway.domain.exception;

public class NonExistentNameException extends RuntimeException {
    private static final String NON_EXISTENT_NAME_ERROR_MESSAGE = "\n[ERROR] 존재하지 않는 역 이름입니다.";

    public NonExistentNameException() {
        super(NON_EXISTENT_NAME_ERROR_MESSAGE);
    }
}
