package subway.domain.menu.exception;

@SuppressWarnings("serial")
public class DuplicatedInputException extends RuntimeException {
    public DuplicatedInputException(String message) {
        super(message);
    }
}
