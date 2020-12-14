package subway.validator;

import subway.domain.LineRepository;
import subway.exception.UserInputException;
import subway.view.lineoutput.LineErrorView;

public class LineValidation extends Validation {
    private static final char WORD_LINE = '선';

    public static boolean checkRegisterLineInput(String userInputLine) {
        if (!checkInputLengthLongerThanTwo(userInputLine)) {
            return false;
        }
        if (!checkNotDuplicateLine(userInputLine)) {
            return false;
        }
        if (!checkInputIsNotSpace(userInputLine)) {
            return false;
        }
        if (!checkEndWithWordLine(userInputLine)) {
            return false;
        }
        return true;
    }

    private static boolean checkNotDuplicateLine(String userInputLine) {
        try {
            if (LineRepository.getLineByName(userInputLine) != null) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineErrorView.printDuplicateLineError();
            return false;
        }
        return true;
    }

    private static boolean checkEndWithWordLine(String userInputLine) {
        try {
            if (userInputLine.charAt(userInputLine.length() - LAST_CHARACTER) != WORD_LINE) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineErrorView.printEndWithWordLineError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteLineInput(String userInputLine) {
        if(!checkIsInLineRepository(userInputLine)) {
            return false;
        }
        return true;
    }

    public static boolean checkIsInLineRepository(String userInputLine) {
        try {
            if (LineRepository.getLineByName(userInputLine) == null) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineErrorView.printNotInLineRepositoryError();
            return false;
        }
        return true;
    }

    public static boolean checkSameTerminus(String upTerminus, String downTerminus) {
        try {
            if (upTerminus.equals(downTerminus)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineErrorView.printSameTerminusInputError();
            return false;
        }
        return true;
    }
}
