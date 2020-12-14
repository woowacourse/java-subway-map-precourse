package exception;

public class AlreadyExistStationNameException extends RuntimeException{
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "이미 존재하는 역 이름입니다.";

    public AlreadyExistStationNameException() {
        super(ERROR + CAUSE);
    }
}
