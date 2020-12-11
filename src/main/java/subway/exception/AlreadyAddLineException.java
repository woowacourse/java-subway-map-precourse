package subway.exception;

public class AlreadyAddLineException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 이미 추가되어있는 노선입니다. INPUT:%s";

    public AlreadyAddLineException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }
}
