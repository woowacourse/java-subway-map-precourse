package subway.line.validation;

import subway.line.Line;

public class CheckRightSectionNumber {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_NUMBER = ERROR_PREFIX + "구간은 숫자로 입력해야합니다.";
    private static final String NOT_EXIST_SECTION = ERROR_PREFIX + "존재하지 않는 구간입니다.";

    public static void validation(Line line, String number) {
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);

            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }

        if (line.isNotExistSection(Integer.parseInt(number))) {
            throw new IllegalArgumentException(NOT_EXIST_SECTION);
        }
    }
}
