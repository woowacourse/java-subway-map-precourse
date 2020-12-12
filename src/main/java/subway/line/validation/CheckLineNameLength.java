package subway.line.validation;

public class CheckLineNameLength {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INVALID_NAME_LENGTH = ERROR_PREFIX + "노선 이름은 2글자 이상이어야 합니다.";

    public static void validation(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
