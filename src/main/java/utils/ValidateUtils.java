package utils;

import java.util.Arrays;
import java.util.List;


public class ValidateUtils {
    private static final List<String> mainValidInputs = Arrays.asList("Q", "1", "2", "3", "4");
    private static final List<String> validInputs = Arrays.asList("B", "1", "2", "3");

    public static boolean validateMainInput(String input) {
        return mainValidInputs.contains(input);
    }

    public static boolean validateInput(String input) {
        return validInputs.contains(input);
    }

    public static boolean validateLengthMoreThanTwo(String input) {
        return input.length() >= 2;
    }
}
