package subway.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super("[ERROR] " + message + "\n");
    }
}
