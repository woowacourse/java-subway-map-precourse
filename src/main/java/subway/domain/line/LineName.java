package subway.domain.line;

import subway.exception.LineNameFormatException;
import subway.exception.LineNameLengthException;

public class LineName {
    private static final int MINIMUM_LINE_NAME_SIZE = 2;
    private static final String LINE_IN_KOREAN = "선";
    
    private String name;

    private LineName(String name) {
        validateName(name);
        this.name = name;
    }

    public static LineName of(String name) {
        return new LineName(name);
    }

    private void validateName(String name) {
        validateEndWithLine(name);
        validateLength(name);
    }

    private void validateEndWithLine(String name) {
        if (!name.endsWith(LINE_IN_KOREAN)) {
            throw new LineNameFormatException();
        }
    }

    private void validateLength(String name) {
        if (!(name.length() - LINE_IN_KOREAN.length() >= MINIMUM_LINE_NAME_SIZE)) {
            throw new LineNameLengthException();
        }
    }
}
