package subway.validator;

import subway.view.ErrorView;
import subway.exception.UserInputException;

public class Validation {
    protected static final String OPTION_ONE = "1";
    protected static final String OPTION_TWO = "2";
    protected static final String OPTION_THREE = "3";
    protected static final String OPTION_FOUR = "4";
    protected static final String OPTION_QUIT = "Q";
    protected static final String OPTION_BACK = "B";

    protected static final int MIN_LENGTH = 2;
    protected static final char EMPTY_CHAR = ' ';

    public static boolean checkControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_THREE)) ||
                    (userInput.equals(OPTION_BACK)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printOptionError();
            return false;
        }
        return true;
    }

    protected static boolean checkInputLengthLongerThanTwo(String userInput) {
        try {
            if (userInput.length() < MIN_LENGTH) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printLengthError();
            return false;
        }
        return true;
    }

    protected static boolean checkInputIsNotSpace(String userInput) {
        try {
            if (!checkNotOnlySpace(userInput)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printInputIsSpaceError();
            return false;
        }
        return true;
    }

    /* userInput이 빈칸으로만 구성되어 있으면 false 반환 */
    private static boolean checkNotOnlySpace(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!(userInput.charAt(i) == EMPTY_CHAR)) {
                return true;
            }
        }
        return false;
    }

}
