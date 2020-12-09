package subway.utils;

import subway.exception.SubwayCustomException;

public class ValidateUtils {

    public static final String NOT_VALID = "not valid";

    public void isValid(String input) {
        // check valid
        throw new SubwayCustomException(NOT_VALID);
    }

}
