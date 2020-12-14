package subway.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subway.domain.LineName;
import subway.exception.validator.LineNameOutOfRangeException;
import subway.exception.validator.PatternSyntaxException;

public final class LineNameValidator extends Validator {

    public static final String LINE_SUFFIX = "선";

    static final String NOT_KOREAN_OR_NUMBER_ERROR = "노선 이름은 한글 또는 숫자만 입력 가능합니다.";

    private static final Pattern KOREAN_OR_NUMBER_PATTERN = Pattern.compile("([가-힣]?[0-9]?)+");

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkRange(input);
        checkKoreanOrNumber(input);
    }

    private void checkKoreanOrNumber(final String input) {
        Matcher matcher = KOREAN_OR_NUMBER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new PatternSyntaxException(NOT_KOREAN_OR_NUMBER_ERROR);
        }
    }

    private void checkRange(String input) {
        if (!input.endsWith(LINE_SUFFIX)) {
            input += LINE_SUFFIX;
        }

        int length = input.length();

        if (length < LineName.LENGTH_LOWER_BOUND || length > LineName.LENGTH_UPPER_BOUND) {
            throw new LineNameOutOfRangeException(length);
        }
    }
}
