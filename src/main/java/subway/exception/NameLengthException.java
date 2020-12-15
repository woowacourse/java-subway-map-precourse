package subway.exception;

public class NameLengthException extends IllegalArgumentException {
    private static final String message = "[ERROR] 이름은 2글자 이상입니다.";

    public NameLengthException() {
        super(message);
    }
}
