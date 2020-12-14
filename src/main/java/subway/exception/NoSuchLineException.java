package subway.exception;

public class NoSuchLineException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 해당 노선은 존재하지 않습니다.";

    public NoSuchLineException() {
        super(ERROR_MESSAGE);
    }
}
