package subway.domain.exception;

public class IncludeInLineException extends RuntimeException {
    private static final String NOT_INCLUDE_ERROR_MESSAGE = "\n[ERROR] 입력하신 노선에 이미 포함되어 있는 역입니다.";

    public IncludeInLineException() {
        super(NOT_INCLUDE_ERROR_MESSAGE);
    }
}
