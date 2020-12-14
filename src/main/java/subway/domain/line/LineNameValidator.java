package subway.domain.line;

import java.util.regex.Pattern;

public class LineNameValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 100;
    private static final String TILDE = "~";
    private static final String SPACE = " ";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String NAME_LENGTH_ERROR_MESSAGE
            = "노선의 이름은 " + MIN_NAME_LENGTH + TILDE + MAX_NAME_LENGTH + " 글자여야 합니다.";
    private static final String NAME_LETTER_TYPE_ERROR_MESSAGE
            = "노선의 이름은 한글, 영어, 숫자, 공백만을 포함해야 합니다.";
    private static final String NAME_SPACE_ERROR_MESSAGE
            = "노선의 이름에는 공백이 2자 연속으로 올 수 없습니다.";

    static void validate(String name) {
        validateNameLength(name);
        validateNameLetterType(name);
        validateNameContainsTwoOrMoreSpace(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE + getNameWithBrackets(name));
        }
    }

    private static void validateNameLetterType(String name) {
        String regex = "^[0-9a-zA-Z가-힣\\s]*$";              // 한글,영어,숫자,공백 허용

        if (!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException(NAME_LETTER_TYPE_ERROR_MESSAGE + getNameWithBrackets(name));
        }
    }

    private static void validateNameContainsTwoOrMoreSpace(String name) {
        if (name.contains(SPACE + SPACE)) {
            throw new IllegalArgumentException(NAME_SPACE_ERROR_MESSAGE + getNameWithBrackets(name));
        }
    }

    private static String getNameWithBrackets(String name) {
        return SPACE + OPEN_BRACKET + name + CLOSE_BRACKET;
    }
}
