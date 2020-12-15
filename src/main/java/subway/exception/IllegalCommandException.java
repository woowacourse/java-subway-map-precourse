package subway.exception;

public class IllegalCommandException extends IllegalArgumentException {
    private static final String message = "[ERROR] 선택할 수 없는 기능입니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
