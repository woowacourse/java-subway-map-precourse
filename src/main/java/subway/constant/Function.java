package subway.constant;

import java.util.ArrayList;
import java.util.List;

public enum Function {

    MANAGE_STATION("1"),
    MANAGE_LINE("2"),
    MANAGE_ROUTE("3"),
    PRINT_MAP("4"),
    QUIT("Q");

    private static List<String> functionCodes = new ArrayList<>();
    private String code;

    Function(String code) {
        this.code = code;
    }

    public static boolean isAvailable(String input) {
        initFunctionValues();
        return functionCodes.contains(input);
    }

    private static void initFunctionValues() {
        for (Function function : Function.values())
            functionCodes.add(function.code);
    }
}
