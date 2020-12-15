package subway.domain;

public class NameValidator {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 2;

    private static String nowInputName;

    public static String makeName(String inputName) {
        nowInputName = inputName;
        checkMaximumSize();
        checkMinimumSize();
        return nowInputName;
    }

    private static void checkMaximumSize() {
        if (nowInputName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("노선의 이름이 너무 깁니다.");
        }
    }

    private static void checkMinimumSize() {
        if (nowInputName.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("노선의 이름이 너무 짧습니다.");
        }
    }
}
