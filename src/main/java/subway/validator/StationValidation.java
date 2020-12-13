package subway.validator;

import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.ErrorView;
import subway.view.stationoutput.StationErrorView;

public class StationValidation extends Validation {
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

    /* 해당 조건 중 만족하지 않는 것이 있다면 재입력 받도록 한다 */
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

    /* 사용자가 입력한 문장이 '역' 으로 끝나지 않으면 예외처리 */
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
