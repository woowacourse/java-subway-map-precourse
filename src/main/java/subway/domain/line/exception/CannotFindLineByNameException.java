package subway.domain.line.exception;

import subway.view.OutputView;

public class CannotFindLineByNameException extends RuntimeException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "등록되지 않은 지하철 노선 입니다. (입력 값: '%s')";

    public CannotFindLineByNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
