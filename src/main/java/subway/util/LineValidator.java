package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineValidator {

    private static final int SIZE = 2;

    public static boolean checkValidLineName(String name) {
        return !checkDuplicateName(name) && checkValidName(name);
    }

    public static boolean checkDuplicateName(String name) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkValidName(String name) {
        if (name.length() >= SIZE) {
            return true;
        }
        return false;
    }
}
