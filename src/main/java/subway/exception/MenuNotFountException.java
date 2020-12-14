package subway.exception;

public class MenuNotFountException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    public MenuNotFountException(String command) {
        super(ERROR_MESSAGE);
    }
}
