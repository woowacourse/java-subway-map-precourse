package subway.controller.exception;

public class DuplicationException extends RuntimeException {
    public DuplicationException(String message) {
        super(message);
    }
}
