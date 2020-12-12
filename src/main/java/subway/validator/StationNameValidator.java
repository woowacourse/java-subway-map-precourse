package subway.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subway.domain.StationName;

public class StationNameValidator extends Validator {

    public static final String INPUT_LENGTH_MESSAGE = "입력하신 글자는 %d자 입니다.";

    public static final String RANGE_ERROR =
            String.format("역 이름은 %d글자 이상, %d글자 이하이어야 합니다. ", StationName.LENGTH_LOWER_BOUND,
                    StationName.LENGTH_UPPER_BOUND);

    public static final String STATION_SUFFIX = "역";

    static final String NOT_KOREAN_ERROR = "역 이름은 한글만 입력 가능합니다.";

    private static final Pattern KOREAN_PATTERN = Pattern.compile("[가-힣]+");

    @Override
    public void validate(String input) {
        super.validate(input);
        checkRange(input);
        checkKorean(input);
    }

    private void checkKorean(String input) {
        Matcher matcher = KOREAN_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_KOREAN_ERROR);
        }
    }

    private void checkRange(String input) {
        if (!input.endsWith(STATION_SUFFIX)) {
            input += STATION_SUFFIX;
        }

        int length = input.length();

        if (length < StationName.LENGTH_LOWER_BOUND || length > StationName.LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    RANGE_ERROR + String.format(INPUT_LENGTH_MESSAGE, length));
        }
    }
}
