package subway.domain.exception;

public class NotIncludeInLineException extends RuntimeException {
    private static final String NOT_INCLUDE_ERROR_MESSAGE = "\n[ERROR] 입력하신 노선에 포함되어 있지 않은 역입니다.";

    public NotIncludeInLineException() {
        super(NOT_INCLUDE_ERROR_MESSAGE);
    }
}
