package subway.exception;

public class TerminalNamesOverlapException extends IllegalArgumentException {
    private static final String message = "[ERROR] 하행 종점과 상행 종점이 같은 역입니다.";

    public TerminalNamesOverlapException() {
        super(message);
    }
}
