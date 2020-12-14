package subway.domain.menu.exception;

@SuppressWarnings("serial")
public class NotAccptedInputLengthException extends RuntimeException {
    public NotAccptedInputLengthException(String message) {
        super(message);
    }
}
