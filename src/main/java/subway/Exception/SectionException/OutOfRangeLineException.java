package subway.Exception.SectionException;

public class OutOfRangeLineException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 넣을 수 없는 구간 순서 입니다";

    public OutOfRangeLineException() {
        super(MESSAGE);
    }
}
