package subway.exception;

public class SectionOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "구간을 추가할 순서는 상행 종점역과 하행 종점역의 사이여야 합니다. (input: \"%d\")";

    public SectionOutOfRangeException(int inputOrder) {
        super(String.format(MESSAGE, inputOrder));
    }
}
