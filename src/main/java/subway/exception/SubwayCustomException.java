package subway.exception;

/**
 * 커스텀 예외 처리 클래스
 */
public class SubwayCustomException extends IllegalArgumentException {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public SubwayCustomException(String message) {
        super(EXCEPTION_PREFIX + message);
    }
}
