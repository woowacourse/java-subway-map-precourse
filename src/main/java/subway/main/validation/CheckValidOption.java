package subway.main.validation;

public class CheckValidOption {
    private static final char EXIT = 'Q';
    private static final char MIN_OPTION_NUMBER = '1';
    private static final char MAX_OPTION_NUMBER = '4';
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INVALID_OPTION = ERROR_PREFIX + "선택할 수 없는 기능입니다.";

    public static void validation(char option) {
        if (option != EXIT && (option < MIN_OPTION_NUMBER || option > MAX_OPTION_NUMBER)) {
            throw new IllegalArgumentException(INVALID_OPTION);
        }
    }
}
