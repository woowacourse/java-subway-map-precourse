package exception;

public class DownLineStationException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "하행 종점 뒤에는 추가하실 수 없습니다.";

    public DownLineStationException(){
        super(ERROR + CAUSE);
    }
}
