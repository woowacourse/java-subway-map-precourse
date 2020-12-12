package subway.domain.exception;

public class NonExistentMenuException extends RuntimeException{
    private static final String NON_EXISTENT_MENU_ERROR_MESSAGE = "\n[ERROR] 선택할 수 없는 기능입니다.";

    public NonExistentMenuException() {
        super(NON_EXISTENT_MENU_ERROR_MESSAGE);
    }
}
