package subway.domain.exception;

public class NonExistentNameException extends RuntimeException {
    private static final String NON_EXISTENT_NAME_ERROR_MESSAGE_START = "\n[ERROR] 존재하지 않는 ";
    private static final String NON_EXISTENT_NAME_ERROR_MESSAGE_END = "이름입니다.";

    public NonExistentNameException(String title) {
        super(NON_EXISTENT_NAME_ERROR_MESSAGE_START + title + NON_EXISTENT_NAME_ERROR_MESSAGE_END);
    }
}
