package exception;

public class NoneFunctionException extends RuntimeException {
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "선택할 수 없는 기능입니다.";

    public NoneFunctionException() {
        super(ERROR + CAUSE);
    }
}
