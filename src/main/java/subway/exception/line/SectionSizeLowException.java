package subway.exception.line;

import subway.view.util.Formatter;

public class SectionSizeLowException extends RuntimeException {
    private static final String MESSAGE = Formatter.Error("구간의 크기는 2보다 작을 수 없습니다.");

    public SectionSizeLowException() {
        super(MESSAGE);
    }
}
