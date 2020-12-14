package subway.exception;

public class SectionOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "이 노선에는 %d 이하의 순서에만 구간을 추가할 수 있습니다. (input: \"%d\")";

    public SectionOutOfRangeException(int inputOrder, int lastOrder) {
        super(String.format(MESSAGE, lastOrder, inputOrder));
    }
}
