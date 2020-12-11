package subway.controller;

import subway.view.OutputView;

public class Function {

    public static final int MAIN_MENU = 0;
    public static final int STATION_MENU = 1;
    public static final int LINE_MENU = 2;
    public static final int AREA_MENU = 3;
    public static final int MAX_MAIN_FUNCTION_DECISION = 4;
    public static final int MAX_STATION_FUNCTION_DECISION = 4;
    public static final int MAX_LINE_FUNCTION_DECISION = 3;
    public static final int MAX_AREA_FUNCTION_DECISION = 2;
    public static final int MIN_FUNCTION_DECISION = 1;
    public static final String EXIT_MAIN_DECISION = "Q";
    public static final String EXIT_NON_MAIN_DECISION = "B";

    public static boolean isExitDecision(String functionDecision, int currentMenu) {
        if(currentMenu == MAIN_MENU) {
            return functionDecision.equalsIgnoreCase(EXIT_MAIN_DECISION);
        }
        return functionDecision.equalsIgnoreCase(EXIT_NON_MAIN_DECISION);
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
        if(currentMenu == MAIN_MENU) return MAX_MAIN_FUNCTION_DECISION;
        if(currentMenu == STATION_MENU) return MAX_STATION_FUNCTION_DECISION;
        if(currentMenu == LINE_MENU) return MAX_LINE_FUNCTION_DECISION;
        return MAX_AREA_FUNCTION_DECISION;
    }
}
