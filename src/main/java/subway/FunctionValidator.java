package subway;

import subway.constant.Function;
import subway.exception.InvalidInputException;


public class FunctionValidator {

    public void validate(String input) throws InvalidInputException {
        if (!Function.isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }
}
