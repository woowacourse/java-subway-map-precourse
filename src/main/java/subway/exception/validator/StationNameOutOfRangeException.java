package subway.exception.validator;

import subway.domain.StationName;

public class StationNameOutOfRangeException extends ValidationException {

    public static final String LENGTH_ERROR = "역 이름은 %d글자 이상, %d글자 이하이어야 합니다. 입력하신 글자는 %d자 입니다.";

    public StationNameOutOfRangeException(int length) {
        super(String.format(LENGTH_ERROR, StationName.LENGTH_LOWER_BOUND,
                StationName.LENGTH_UPPER_BOUND, length));
    }
}
