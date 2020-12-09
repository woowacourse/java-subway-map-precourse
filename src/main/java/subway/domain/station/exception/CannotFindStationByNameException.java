package subway.domain.station.exception;

import subway.view.OutputView;

public class CannotFindStationByNameException extends RuntimeException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "등록되지 않은 지하철 역 입니다. (입력 값: '%s')";

    public CannotFindStationByNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
