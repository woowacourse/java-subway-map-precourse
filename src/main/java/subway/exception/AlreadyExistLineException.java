package subway.exception;

public class AlreadyExistLineException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 이미 등록된 노선입니다.";

    public AlreadyExistLineException() {
        super(ERROR_MESSAGE);
    }
}
