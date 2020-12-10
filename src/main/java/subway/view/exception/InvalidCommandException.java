package subway.view.exception;

import subway.view.OutputView;

public class InvalidCommandException extends RuntimeException {

    private static final String MESSAGE =
        OutputView.ERROR_PREFIX + "선택할 수 없는 기능입니다. (입력 값: '%s')";

    public InvalidCommandException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
