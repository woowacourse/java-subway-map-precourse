package subway.line.validation;

import subway.common.Prefix;
import subway.line.Line;

public class CheckRightSectionNumber {
    private static final String NOT_NUMBER = Prefix.ERROR.getPrefix() + "구간은 숫자로 입력해야합니다.";
    private static final String NOT_EXIST_SECTION = Prefix.ERROR.getPrefix() + "존재하지 않는 구간입니다.";

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
