package subway.exception;

public class LineNameDuplicateException extends IllegalArgumentException {
    private static final String message = "[ERROR] 이미 등록된 노선 이름입니다.";

    public LineNameDuplicateException() {
        super(message);
    }
}
