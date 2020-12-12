package subway.domain;

import static subway.domain.StationNameValidator.MAXIMUM_NAME_LENGTH;
import static subway.domain.StationNameValidator.MINIMUM_NAME_LENGTH;

public class LineNameValidator {
    private static String nowInputName;

    public static String makeName(String inputName) {
        nowInputName = inputName;
        checkDuplicate();
        checkMinimumSize();
        checkMaximumSize();
        return nowInputName;
    }

    private static void checkDuplicate() {
        if (LineRepository.findLineByName(nowInputName) != null) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
    }

    private static void checkMinimumSize() {
        if (nowInputName.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("노선의 이름이 너무 짧습니다.");
        }
    }

    private static void checkMaximumSize() {
        if (nowInputName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("노선의 이름이 너무 깁니다.");
        }
    }

    public static String makeEnrolledLineName(String inputRemoveName) {
        nowInputName = inputRemoveName;
        checkNotEnrolledName();
        return nowInputName;
    }

    private static void checkNotEnrolledName() {
        if (LineRepository.findLineByName(nowInputName) == null) {
            throw new IllegalArgumentException("일치하는 노선이 없습니다.");
        }
    }
}
