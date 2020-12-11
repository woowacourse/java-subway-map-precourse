package subway.exception;

/**
 * 커스텀 예외 처리 클래스
 */
public class SubwayCustomException extends IllegalArgumentException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public SubwayCustomException(String message) {
        super(ERROR_PREFIX + message);
    }
}
