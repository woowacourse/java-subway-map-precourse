package subway.controller.validation;

import subway.controller.message.MainMessage;
import subway.view.SubwayView;

public class MainValidator {
    private static final String MAIN_FUNCTION_REGULAR_EXPRESSION = "^([1-4Q])$";

    public static boolean isValidMainFunction(String functionCode) {
        if (functionCode.matches(MAIN_FUNCTION_REGULAR_EXPRESSION)) {
            return true;
        }
        return false;
    }

    public static String validateMainFunction(String functionCode) {
        if (isValidMainFunction(functionCode)) {
            return functionCode;
        }

        SubwayView.error(MainMessage.ERROR_SELECT_FUNCTION);
        SubwayView.notice(MainMessage.SELECT_FUNCTION);
        functionCode = SubwayView.userInput();
        functionCode = validateMainFunction(functionCode);
        return functionCode;
    }
}
