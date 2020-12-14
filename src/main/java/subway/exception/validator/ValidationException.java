package subway.exception.validator;

import subway.exception.SubwayRuntimeException;

public class ValidationException extends SubwayRuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
