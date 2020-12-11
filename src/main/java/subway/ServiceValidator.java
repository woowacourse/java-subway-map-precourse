package subway;

import subway.constant.Service;
import subway.exception.InvalidInputException;


public class ServiceValidator {

    public void validate(String input) throws InvalidInputException {
        if (!Service.isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }
}
