package subway.validator;

import subway.exception.UserInputException;
import subway.view.ErrorView;

public class MainValidation extends Validation {
    public static boolean checkControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_THREE)) ||
                    (userInput.equals(OPTION_FOUR)) || (userInput.equals(OPTION_QUIT)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printOptionError();
            return false;
        }
        return true;
    }
}
