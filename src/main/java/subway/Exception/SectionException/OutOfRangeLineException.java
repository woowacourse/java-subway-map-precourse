package subway.Exception.SectionException;

public class OutOfRangeLineException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 넣을 수 없는 구간 순서 입니다. (해당 노선 구간 수 : %s)";

    public OutOfRangeLineException(int sectionSize) {
        super(String.format(MESSAGE, sectionSize));
    }
}
