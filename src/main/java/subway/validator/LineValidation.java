package subway.validator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.lineoutput.LineErrorView;
import subway.view.linesectionoutput.LineSectionErrorView;

public class LineValidation extends Validation {
    private static final char WORD_LINE = '선';

    /* 해당 조건 중 만족하지 않는 것이 있다면 재입력 받도록 한다 */
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
            if (LineRepository.haveLine(userInputLine)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            LineErrorView.printDuplicateLineError();
            return false;
        }
        return true;
    }

    /* 사용자가 입력한 문장이 '선' 으로 끝나지 않으면 예외처리 */
    private static boolean checkEndWithWordLine(String userInputLine) {
        try {
            if (userInputLine.charAt(userInputLine.length() - 1) != WORD_LINE) {
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
            if (!LineRepository.haveLine(userInputLine)) {
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
