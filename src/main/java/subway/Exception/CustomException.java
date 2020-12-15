package subway.Exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super("[ERROR] " + message + "\n");
    }
}
