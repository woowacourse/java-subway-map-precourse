package subway.Exception.SectionException;

public class ShorterThanMinLineSizeException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 노선에 구간이 2개 이하 이므로 구간을 제거할 수 없습니다.";

    public ShorterThanMinLineSizeException() {
        super(MESSAGE);
    }
}
