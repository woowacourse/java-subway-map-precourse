package subway.domain.exception;

public class AlreadyExistingLineException extends IllegalArgumentException {
    public AlreadyExistingLineException() {
        super("이미 존재하는 노선입니다.");
    }
}
