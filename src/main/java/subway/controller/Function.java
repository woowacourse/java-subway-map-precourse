package subway.controller;

import subway.view.OutputView;

public class Function {

    public static final int MAX_MAIN_FUNCTION_DECISION = 4;
    public static final int MIN_FUNCTION_DECISION = 1;
    public static final String EXIT_FUNCTION_DECISION = "Q";

    public static boolean isExitDecision(String functionDecision) {
        return functionDecision.equalsIgnoreCase(EXIT_FUNCTION_DECISION);
    }

    public static void validate(String functionDecision, int currentMenu) {
        validateNumeric(functionDecision);
        validateRange(functionDecision, currentMenu);
    }

    private static void validateNumeric(String functionDecision) {
        try {
            Integer.parseInt(functionDecision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_NOT_NUMERIC);
        }
    }

    private static void validateRange(String functionDecision, int currentMenu) {
        if (outOfRange(Integer.parseInt(functionDecision), currentMenu)) {
            throw new IllegalArgumentException(OutputView.ERROR_OUT_OF_RANGE);
        }
    }

    private static boolean outOfRange(int functionDecision, int currentMenu) {
        return (functionDecision > getMaxDecision(currentMenu)
                || functionDecision < MIN_FUNCTION_DECISION);
    }

    private static int getMaxDecision(int currentMenu) {
        if(currentMenu == 0) return MAX_MAIN_FUNCTION_DECISION;
        return MAX_MAIN_FUNCTION_DECISION;
    }
}
