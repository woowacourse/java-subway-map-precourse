package subway.validator;

import subway.domain.StationRepository;
import subway.view.ErrorView;
import subway.exception.UserInputException;
import subway.view.stationoutput.StationErrorView;

public class Validation {
    protected static final String OPTION_ONE = "1";
    protected static final String OPTION_TWO = "2";
    protected static final String OPTION_THREE = "3";
    protected static final String OPTION_FOUR = "4";
    protected static final String OPTION_QUIT = "Q";
    protected static final String OPTION_BACK = "B";

    protected static final int MIN_LENGTH = 2;
    protected static final char EMPTY_CHAR = ' ';
    protected static final char WORD_STATION = '역';

    protected static boolean checkInputLength(String userInputStation) {
        try {
            if (userInputStation.length() < MIN_LENGTH) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printLengthError();
            return false;
        }
        return true;
    }

    protected static boolean checkInputIsNotSpace(String userInput) {
        try {
            if (checkNotOnlySpace(userInput) == false) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printInputIsSpaceError();
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
