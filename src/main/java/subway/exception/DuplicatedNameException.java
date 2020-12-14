package subway.exception;

public class DuplicatedNameException extends IllegalArgumentException {
    private static final String message = "[ERROR] 이미 등록된 역 이름입니다. ";

    @Override
    public String getMessage() {
        return message;
    }
}
