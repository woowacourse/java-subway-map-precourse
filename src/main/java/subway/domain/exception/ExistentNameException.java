package subway.domain.exception;

public class ExistentNameException extends RuntimeException {
    private static final String EXISTENT_NAME_ERROR_MESSAGE_START = "\n[ERROR] 이미 등록된 ";
    private static final String EXISTENT_NAME_ERROR_MESSAGE_END = "이름입니다.";

    public ExistentNameException(String title) {
        super(EXISTENT_NAME_ERROR_MESSAGE_START + title + EXISTENT_NAME_ERROR_MESSAGE_END);
    }
}
