package subway.exception.function;

public class AlreadySavedAtLineException extends FunctionException {

    public static final String SAVED_AT_LINE_ERROR = "노선에 등록된 역은 삭제할 수 없습니다.";

    public AlreadySavedAtLineException() {
        super(SAVED_AT_LINE_ERROR);
    }
}
