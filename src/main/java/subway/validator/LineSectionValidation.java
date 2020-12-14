package subway.validator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.ErrorView;
import subway.view.linesectionoutput.LineSectionErrorView;

public class LineSectionValidation extends Validation {
    private static int NOT_NATURAL_NUMBER = 0;
    private static int AVAILABLE_SECTION = 1;
    private static int MINIMUM_STATION_IN_LINE = 2;

    public static boolean checkControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_BACK)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printOptionError();
            return false;
        }
        return true;
    }

    public static boolean checkAvailableStationToRegister(String userInputLine, String userInputStation) {
        if (!StationValidation.checkIsInStationRepository(userInputStation)) {
            return false;
        }
        if (!checkNotAlreadyInLine(userInputLine, userInputStation)) {
            return false;
        }
        return true;
    }

    private static boolean checkNotAlreadyInLine(String userInputLine, String userInputStation) {
        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation =  StationRepository.getStationByName(userInputStation);
        try {
            if (registerLine.checkStationInLine(sectionStation)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineSectionErrorView.printAlreadyInLineError();
            return false;
        }
        return true;
    }

    public static boolean checkAvailableOrderToRegister(String userInputLine, String userInputOrder) {
        int order = checkUserInputOrderNaturalNumber(userInputOrder);
        if (order == NOT_NATURAL_NUMBER) {
            return false;
        }
        if (!checkAvailableOrderInLine(userInputLine, order)) {
            return false;
        }
        return true;
    }

    private static int checkUserInputOrderNaturalNumber(String userInputOrder) {
        int order = NOT_NATURAL_NUMBER;
        try {
            order = Integer.parseInt(userInputOrder);
            if (order <= NOT_NATURAL_NUMBER) {
                throw new UserInputException();
            }
        } catch (NumberFormatException e) {
            LineSectionErrorView.printInvalidNumberInputError();
            return order;
        } catch (UserInputException e) {
            LineSectionErrorView.printInvalidNumberInputError();
            return order;
        }
        return order;
    }

    private static boolean checkAvailableOrderInLine(String userInputLine, int order) {
        try{
            if(LineRepository.getLineByName(userInputLine).getStationsInLine().size() + AVAILABLE_SECTION < order) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineSectionErrorView.printInvalidOrderError();
            return false;
        }
        return true;
    }

    public static boolean checkAvailableLineForDeletion(String userInputLine) {
        if(!LineValidation.checkIsInLineRepository(userInputLine)) {
            return false;
        }
        if(!checkNumberOfStationsInLine(userInputLine)) {
            return false;
        }
        return true;
    }

    public static boolean checkNumberOfStationsInLine(String userInputLine) {
        Line registerLine = LineRepository.getLineByName(userInputLine);
        try {
            if (registerLine.getStationsInLine().size() <= MINIMUM_STATION_IN_LINE) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineSectionErrorView.printFewStationsInLineError();
            return false;
        }
        return true;
    }

    public static boolean checkAvailableStationForDeletion(String userInputLine, String userInputStation) {
        if (!StationValidation.checkIsInStationRepository(userInputStation)) {
            return false;
        }
        if (!checkIsInLine(userInputLine, userInputStation)) {
            return false;
        }
        return true;
    }

    private static boolean checkIsInLine(String userInputLine, String userInputStation) {
        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation =  StationRepository.getStationByName(userInputStation);
        try {
            if (!registerLine.checkStationInLine(sectionStation)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineSectionErrorView.printNotInLineError();
            return false;
        }
        return true;
    }
}
