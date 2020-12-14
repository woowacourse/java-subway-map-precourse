package exception;

public class OverRangeException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "입력값을 다시 확인해주세요.";
    public OverRangeException(){
        super(ERROR + CAUSE);
    }
}
