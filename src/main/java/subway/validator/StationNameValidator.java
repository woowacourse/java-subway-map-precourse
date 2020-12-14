package subway.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subway.domain.StationName;
import subway.exception.validator.PatternSyntaxException;
import subway.exception.validator.StationNameOutOfRangeException;

public final class StationNameValidator extends Validator {

    public static final String STATION_SUFFIX = "역";

    static final String NOT_KOREAN_ERROR = "역 이름은 한글만 입력 가능합니다.";

    private static final Pattern KOREAN_PATTERN = Pattern.compile("[가-힣]+");

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkRange(input);
        checkKorean(input);
    }

    private void checkKorean(final String input) {
        Matcher matcher = KOREAN_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new PatternSyntaxException(NOT_KOREAN_ERROR);
        }
    }

    private void checkRange(String input) {
        if (!input.endsWith(STATION_SUFFIX)) {
            input += STATION_SUFFIX;
        }

        int length = input.length();

        if (length < StationName.LENGTH_LOWER_BOUND || length > StationName.LENGTH_UPPER_BOUND) {
            throw new StationNameOutOfRangeException(length);
        }
    }
}
