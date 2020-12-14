package subway.domain.exception;

public class NonExistingLineException extends IllegalArgumentException {
    public NonExistingLineException() {
        super("존재하지 않는 노선입니다.");
    }
}
