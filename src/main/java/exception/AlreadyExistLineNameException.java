package exception;

public class AlreadyExistNameException extends RuntimeException {
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "이미 존재하는 이름입니다.";

    public AlreadyExistNameException() {
        super(ERROR + CAUSE);
    }
}
