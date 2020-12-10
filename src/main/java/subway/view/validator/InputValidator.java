package subway.view.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    static final String NOT_KOREAN_ERROR = "역 이름은 한글만 입력 가능합니다.";

    static final String NULL_ERROR = "null 값을 입력하셨습니다.";

    private static final Pattern KOREAN_PATTERN = Pattern.compile("[가-힣]+");

    private static final int LENGTH_LOWER_BOUND = 2;

    private static final int LENGTH_UPPER_BOUND = 10;

    static final String RANGE_ERROR = String.format("이름은 %d글자 이상, %d글자 이하이어야 합니다.", LENGTH_LOWER_BOUND, LENGTH_UPPER_BOUND);

    public void validate(String input) {
        checkNull(input);
        checkRange(input);
        checkKorean(input);
    }

    private void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
    }

    private void checkRange(String input) {
        int length = input.length();

        if (length < LENGTH_LOWER_BOUND || length > LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void checkKorean(String input) {
        Matcher matcher = KOREAN_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_KOREAN_ERROR);
        }
    }
}
