package subway.exception.validator;

import subway.exception.SubwayRuntimeException;

public class ValidationException extends SubwayRuntimeException {

    public static final String NULL_ERROR = "null 값을 입력하셨습니다.";

    public ValidationException() {
        super(NULL_ERROR);
    }

    public ValidationException(String message) {
        super(message);
    }
}
