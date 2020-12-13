package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.view.OutputView;

public class Function {

    public static final int MAIN_MENU = 0;
    public static final int STATION_MENU = 1;
    public static final int LINE_MENU = 2;
    public static final int SECTION_MENU = 3;
    public static final int MAX_MAIN_FUNCTION_DECISION = 4;
    public static final int MAX_STATION_FUNCTION_DECISION = 4;
    public static final int MAX_LINE_FUNCTION_DECISION = 3;
    public static final int MAX_SECTION_FUNCTION_DECISION = 2;
    public static final int MIN_FUNCTION_DECISION = 1;
    public static final String EXIT_MAIN_DECISION = "Q";
    public static final String EXIT_NON_MAIN_DECISION = "B";

    private static final List<Integer> menuMaxDecisionCounts = new ArrayList<>(Arrays.asList(
            MAX_MAIN_FUNCTION_DECISION,
            MAX_STATION_FUNCTION_DECISION,
            MAX_LINE_FUNCTION_DECISION,
            MAX_SECTION_FUNCTION_DECISION
    ));

    public static boolean isExitDecision(String functionDecision, int currentMenu) {
        if (currentMenu == MAIN_MENU) {
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
        return menuMaxDecisionCounts.get(currentMenu);
    }
}
