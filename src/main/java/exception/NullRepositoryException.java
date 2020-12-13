package exception;

public class NullRepositoryException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "저장되어 있는 데이터가 없습니다.";

    public NullRepositoryException(){
        super(ERROR + CAUSE);
    }
}
