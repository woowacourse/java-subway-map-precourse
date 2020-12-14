package subway.domain.menu.exception;

@SuppressWarnings("serial")
public class NotAccptedInputException extends RuntimeException {
    public NotAccptedInputException(String message) {
        super(message);
    }
}
