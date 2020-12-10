package subway.station.exception;

import subway.view.OutputView;

public class DuplicateStationNameException extends IllegalArgumentException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "이미 존재하는 역 이름입니다. (입력 값: '%s')";

    public DuplicateStationNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
