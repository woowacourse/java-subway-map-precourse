package subway.utils;

import subway.exception.SubwayProgramException;

public class InputValidator {
    private static final String INCORRECT_NUMBER_ERROR = "순서는 숫자로 입력해주세요.";

    private InputValidator() {
    }

    public static int validateInteger(String index) {
        try {
            return Integer.parseInt(index);
        } catch (IllegalArgumentException e) {
            throw new SubwayProgramException(INCORRECT_NUMBER_ERROR);
        }
    }
}
