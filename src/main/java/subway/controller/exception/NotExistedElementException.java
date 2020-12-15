package subway.controller.exception;

public class NotExistedElementException extends RuntimeException {
    public NotExistedElementException(String message) {
        super(message);
    }
}
