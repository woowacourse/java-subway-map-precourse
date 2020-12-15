package subway.system.validator;

public class SubwaySystemInputValidator {
    static final String WANT_QUIT_CODE = "Q";
    static final String ERROR_MESSAGE = "1~4 또는 Q 옵션 중 하나를 입력하세요";
    static final int OPTION_MIN = 1;
    static final int OPTION_MAX = 4;

    public static void validateUserOption(String userOption) throws IllegalArgumentException {
        if (userOption.equals(WANT_QUIT_CODE)) {
            return;
        }
        try {
            int optionNumber = Integer.parseInt(userOption);
            if (optionNumber < OPTION_MIN || optionNumber > OPTION_MAX) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
