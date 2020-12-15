package subway.exception;

public class LineNameNotFoundException extends IllegalArgumentException {
    private static final String message = "[ERROR] 등록 되어 있지 않은 노선입니다.";

    public LineNameNotFoundException() {
        super(message);
    }
}
