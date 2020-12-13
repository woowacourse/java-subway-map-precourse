package exception;

public class NoExistLineNameException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "존재하지 않는 노선입니다.";

    public NoExistLineNameException() {
        super(ERROR + CAUSE);
    }
}
