package exception;

public class UpLineStationException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "순서는 1부터 쓸 수 있습니다.";

    public UpLineStationException(){
        super(ERROR + CAUSE);
    }
}
