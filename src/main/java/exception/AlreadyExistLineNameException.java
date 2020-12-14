package exception;

public class AlreadyExistLineNameException extends RuntimeException {
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "이미 존재하는 노선 이름입니다.";

    public AlreadyExistLineNameException() {
        super(ERROR + CAUSE);
    }
}
