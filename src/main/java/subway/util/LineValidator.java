package subway.util;

import subway.domain.Line;

import java.util.List;

public class LineValidator {

    private static final int SIZE = 2;

    public static boolean checkDuplicateName(String name, List<Line> lines) {
        for (Line line : lines) {
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
