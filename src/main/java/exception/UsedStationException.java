package exception;

public class UsedStationException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "노선에 추가되어 삭제할 수 없습니다.";
    public UsedStationException(){
        super(ERROR + CAUSE);
    }
}
