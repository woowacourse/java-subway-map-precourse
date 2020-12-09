package subway.domain.line.exception;

import subway.view.OutputView;

public class DuplicateLineNameException extends IllegalArgumentException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "이미 존재하는 노선 이름입니다. (입력 값: '%s')";

    public DuplicateLineNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
