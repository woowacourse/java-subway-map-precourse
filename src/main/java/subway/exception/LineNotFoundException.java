package subway.exception;

public class LineNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 해당 노선이 존재하지 않습니다. INPUT : %s";

    public LineNotFoundException(String input) {
        super(String.format(ERROR_MESSAGE,input));
    }
}
