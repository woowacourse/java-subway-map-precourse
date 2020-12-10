package validator;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public void inputValidFunction(String input) {
        List<String> mainFunc = Arrays.asList("1", "2", "3", "4", "Q");
        if (!mainFunc.contains(input))
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_FUNCTION);
    }

    public void inputValidStationFunction(String input) {
        List<String> stationFunc = Arrays.asList("1", "2", "3", "B");
        if (!stationFunc.contains(input))
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_FUNCTION);
    }
}
