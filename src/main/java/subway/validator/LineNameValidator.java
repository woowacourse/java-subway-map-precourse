package subway.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subway.domain.LineName;

public class LineNameValidator extends Validator {

    public static final String INPUT_LENGTH_MESSAGE = "입력하신 글자는 %d자 입니다.";

    public static final String RANGE_ERROR =
            String.format("노선 이름은 %d글자 이상, %d글자 이하이어야 합니다. ", LineName.LENGTH_LOWER_BOUND,
                    LineName.LENGTH_UPPER_BOUND);

    static final String NOT_KOREAN_OR_NUMBER_ERROR = "노선 이름은 한글 또는 숫자만 입력 가능합니다.";

    private static final Pattern KOREAN_OR_NUMBER_PATTERN = Pattern.compile("([가-힣]?[0-9]?)+");

    private static final String LINE_POST_FIX = "선";

    @Override
    public void validate(String input) {
        super.validate(input);
        checkRange(input);
        checkKoreanOrNumber(input);
    }

    private void checkKoreanOrNumber(String input) {
        Matcher matcher = KOREAN_OR_NUMBER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_KOREAN_OR_NUMBER_ERROR);
        }
    }

    private void checkRange(String input) {
        if (!input.endsWith(LINE_POST_FIX)) {
            input = input + LINE_POST_FIX;
        }

        int length = input.length();

        if (length < LineName.LENGTH_LOWER_BOUND || length > LineName.LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    RANGE_ERROR + String.format(INPUT_LENGTH_MESSAGE, length));
        }
    }
}
