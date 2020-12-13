package subway.line.exception;

public class IllegalTypeOfNameException extends IllegalArgumentException {
    private static final String MESSAGE = "지하철 노선은 한글 혹은 숫자로 입력해 주세요.";

    public IllegalTypeOfNameException() {
        super(MESSAGE);
    }
}
