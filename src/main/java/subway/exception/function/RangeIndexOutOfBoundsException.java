package subway.exception.function;

import subway.domain.StationRepository;

public class RangeIndexOutOfBoundsException extends FunctionException {

    public static final String OUT_OF_BOUNDS_ERROR = "노선의 범위를 벗어난 구간입니다. %d 초과 %d 미만의 값을 입력해주세요.";

    public static final String LOWER_THAN_MINIMUM_ERROR =
            StationRepository.MINIMUM_INDEX + "초과의 값을 입력해주세요.";

    public RangeIndexOutOfBoundsException() {
        super(LOWER_THAN_MINIMUM_ERROR);
    }

    public RangeIndexOutOfBoundsException(int upperBound) {
        super(String.format(OUT_OF_BOUNDS_ERROR, StationRepository.MINIMUM_INDEX, upperBound));
    }
}
