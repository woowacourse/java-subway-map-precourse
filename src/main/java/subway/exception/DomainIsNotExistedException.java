package subway.exception;

public class DomainIsNotExistedException extends Exception {
    private static final String message = "[ERROR] 해당 도메인은 존재하지 않습니다";

    @Override
    public String getMessage() {
        return message;
    }
}
