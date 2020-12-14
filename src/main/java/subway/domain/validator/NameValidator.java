package subway.domain.validator;

public class NameValidator {
    private static final String SHORTER_THAN_MINIMUM_ERROR = "이름의 길이는 %s 이상이어야 합니다.";

    private NameValidator() {
    }

    public static void checkIsValidLength(String name, int minimum) {
        if (name.length() < minimum) {
            String errorMsg = String.format(SHORTER_THAN_MINIMUM_ERROR, minimum);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
