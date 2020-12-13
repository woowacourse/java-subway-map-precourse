package exception;


public class NoExistStationNameException extends RuntimeException {
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "이미 존재하지 않는 역입니다.";

    public NoExistStationNameException() {
        super(ERROR + CAUSE);
    }
}
