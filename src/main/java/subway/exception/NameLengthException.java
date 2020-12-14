package subway.exception;

public class NameLengthException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 이름의 길이는 최소 2글자 이상 이어야 합니다.";

    public NameLengthException() {
        super(ERROR_MESSAGE);
    }
}
