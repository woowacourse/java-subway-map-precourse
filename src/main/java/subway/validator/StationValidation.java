package subway.validator;

import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.stationoutput.StationErrorView;

public class StationValidation extends Validation {
    private static final char WORD_STATION = '역';

    /* 해당 조건 중 만족하지 않는 것이 있다면 재입력 받도록 한다 */
    public static boolean checkRegisterStationInput(String userInputStation) {
        if (!checkInputLengthLongerThanTwo(userInputStation)) {
            return false;
        }
        if (!checkNotDuplicateStation(userInputStation)) {
            return false;
        }
        if (!checkInputIsNotSpace(userInputStation)) {
            return false;
        }
        if (!checkEndWithWordStation(userInputStation)) {
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

    public static boolean checkIsInStationRepository(String userInputStation) {
        try {
            if (!StationRepository.haveStation(userInputStation)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printNotInStationRepositoryError();
            return false;
        }
        return true;
    }
}
