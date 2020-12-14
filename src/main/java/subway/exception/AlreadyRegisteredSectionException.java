package subway.exception;

public class AlreadyRegisteredSectionException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 이미 구간에 포함된 역입니다.";

    public AlreadyRegisteredSectionException() {
        super(ERROR_MESSAGE);
    }
}
