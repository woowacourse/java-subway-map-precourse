package subway.domain.station.exception;

import subway.view.OutputView;

public class CannotDeleteStationAlreadyAddedLineException extends RuntimeException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "노선에 등록된 역은 삭제할 수 없습니다. (입력 값: '%s')";

    public CannotDeleteStationAlreadyAddedLineException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
