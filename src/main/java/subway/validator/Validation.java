package subway.validator;

import subway.domain.StationRepository;
import subway.view.ErrorView;
import subway.exception.UserInputException;
import subway.view.stationoutput.StationErrorView;

public class Validation {
    private static final String OPTION_ONE = "1";
    private static final String OPTION_TWO = "2";
    private static final String OPTION_THREE = "3";
    private static final String OPTION_FOUR = "4";
    private static final String OPTION_QUIT = "Q";
    private static final String OPTION_BACK = "B";
    private static final int MIN_LENGTH = 2;
    private static final char EMPTY_CHAR = ' ';
    private static final char WORD_STATION = '역';

    public static boolean checkMainControllerInput(String userInput) {
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

    public static boolean checkStationControllerInput(String userInput) {
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

    public static boolean checkRegisterStationInput(String userInputStation) {
        if (checkInputLength(userInputStation) == false) {
            return false;
        }
        if (checkNotDuplicateStation(userInputStation) == false) {
            return false;
        }
        if (checkInputIsNotSpace(userInputStation) == false) {
            return false;
        }
        if (checkEndWithWordStation(userInputStation) == false) {
            return false;
        }
        return true;
    }

    private static boolean checkInputLength(String userInputStation) {
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

    private static boolean checkNotDuplicateStation(String userInputStation) {
        try {
            if (StationRepository.haveStation(userInputStation)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printDuplicateStationError();
            return false;
        }
        return true;
    }

    private static boolean checkInputIsNotSpace(String userInputStation) {
        try {
            /* String userInputStation이 빈칸으로만 구성되어 있으면 예외처리 */
            if (checkNotOnlySpace(userInputStation) == false) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printInputIsSpaceError();
            return false;
        }
        return true;
    }

    /* String userInputStation이 빈칸으로만 구성되어 있으면 false 반환 */
    private static boolean checkNotOnlySpace(String userInputStation) {
        for (int i = 0; i < userInputStation.length(); i++) {
            if (!(userInputStation.charAt(i) == EMPTY_CHAR)) {
                return true;
            }
        }
        return false;
    }


    /* 사용자가 입력한 문장이 '역'으로 끝나지 않으면 예외처리 */
    private static boolean checkEndWithWordStation(String userInputStation) {
        try {
            if (userInputStation.charAt(userInputStation.length() - 1) != WORD_STATION) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printEndWithWordStationError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteStationInput(String userInputStation) {
        if(checkIsInStationRepository(userInputStation) == false) {
            return false;
        }
        return true;
    }

    private static boolean checkIsInStationRepository(String userInputStation) {
        try {
            if (StationRepository.haveStation(userInputStation) == false) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printNotInStationRepositoryError();
            return false;
        }
        return true;
    }
}
