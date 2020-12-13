package subway.exception;

public class ExitSystemException extends RuntimeException{
    public static final String SYSTEM_EXIT_MESSAGE = "지하철 시스템이 종료되었습니다.";

    public ExitSystemException() {
        super(SYSTEM_EXIT_MESSAGE);
    }
}
