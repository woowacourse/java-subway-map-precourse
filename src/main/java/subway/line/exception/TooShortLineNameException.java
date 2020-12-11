package subway.line.exception;

import subway.line.domain.Line;

public class TooShortLineNameException extends IllegalArgumentException {
    private static final String MESSAGE = "지하철 노선 이름은 " + Line.MIN_NAME_LENGTH + "글자 이상으로 입력해 주세요.";

    public TooShortLineNameException() {
        super(MESSAGE);
    }
}
