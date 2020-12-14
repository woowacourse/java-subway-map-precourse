package subway.exception;

public class ShortNameException extends IllegalArgumentException {
    private static final String message = "[ERROR] 최소한 2글자 이상이어야 합니다. ";

    @Override
    public String getMessage() {
        return message;
    }
}
