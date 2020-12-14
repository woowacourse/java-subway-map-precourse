package subway.validator;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.stationoutput.StationErrorView;

public class StationValidation extends Validation {
    private static final char WORD_STATION = '역';
    private static final int STATION_IS_NOT_IN_ANY_LINE = 0;

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
            if (StationRepository.getStationByName(userInputStation) != null) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printDuplicateStationError();
            return false;
        }
        return true;
    }

    private static boolean checkEndWithWordStation(String userInputStation) {
        try {
            if (userInputStation.charAt(userInputStation.length() - LAST_CHARACTER) != WORD_STATION) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printEndWithWordStationError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteStationInput(String userInputLine) {
        if (!checkIsInStationRepository(userInputLine)) {
            return false;
        }
        if (!checkStationBelongToAnyLine(userInputLine)) {
            return false;
        }
        return true;
    }

    public static boolean checkIsInStationRepository(String userInputStation) {
        try {
            if (StationRepository.getStationByName(userInputStation) == null) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printNotInStationRepositoryError();
            return false;
        }
        return true;
    }

    private static boolean checkStationBelongToAnyLine(String userInputLine) {
        Station station = StationRepository.getStationByName(userInputLine);
        try {
            if (station.getBelongToWhichLine().size() != STATION_IS_NOT_IN_ANY_LINE) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            StationErrorView.printStationIsInLineError();
            return false;
        }
        return true;
    }
}
