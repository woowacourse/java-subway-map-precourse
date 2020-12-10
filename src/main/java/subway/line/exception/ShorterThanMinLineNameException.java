package subway.line.exception;

import subway.line.domain.Line;

public class ShorterThanMinLineNameException extends IllegalArgumentException {

    private static final String MESSAGE = "지하철 노선 이름은 " + Line.MIN_NAME_SIZE
            + "글자 이상이어야 합니다. (입력 값: '%s')";

    public ShorterThanMinLineNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
