package util.validator;

import subway.view.OutputView;
import util.exception.UserInputException;

public class Validation {
    private static final String OPTION_ONE = "1";
    private static final String OPTION_TWO = "2";
    private static final String OPTION_THREE = "3";
    private static final String OPTION_FOUR = "4";
    private static final String OPTION_QUIT = "Q";
    private static final String OPTION_BACK = "B";

    private static final String ERROR_WRONG_OPTION = "[ERROR] 선택할 수 없는 기능입니다.";

    public static boolean checkMainControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_THREE)) ||
                    (userInput.equals(OPTION_FOUR)) || (userInput.equals(OPTION_QUIT)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            OutputView.printOptionError();
            return false;
        }
        return true;
    }

    public static boolean checkStationControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_THREE)) ||
                    (userInput.equals(OPTION_BACK)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            OutputView.printOptionError();
            return false;
        }
        return true;
    }
}
