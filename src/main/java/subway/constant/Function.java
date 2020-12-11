package subway.constant;

import subway.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public enum Function {

    ADD("1"),
    DELETE("2"),
    SHOW("3"),
    QUIT("B");

    private static List<String> functionCodes = new ArrayList<>();
    private String code;

    Function(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static void validate(String input) throws InvalidInputException {
        if (!isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }

    private static boolean isAvailable(String input) {
        initFunctionCodes();
        return functionCodes.contains(input);
    }

    private static void initFunctionCodes() {
        for (Function function : Function.values())
            functionCodes.add(function.code);
    }
}
