package subway.exception;

public class NoInitialScannerException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] Scanner를 먼저 넣어주세요.";

    public NoInitialScannerException() {
        super(ERROR_MESSAGE);
    }
}
