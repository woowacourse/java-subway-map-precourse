package subway.Exception.LineException;

public class CanNotFindLineException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 등록되지 않은 노선 입니다.";

    public CanNotFindLineException() {
        super(MESSAGE);
    }
}
