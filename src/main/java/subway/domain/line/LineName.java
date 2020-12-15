package subway.domain.line;

import subway.domain.station.StationName;
import subway.exception.SubwayApplicationException;
import subway.exception.line.LineNameFormatException;
import subway.exception.line.LineNameLengthException;

import java.util.Objects;

public class LineName {
    private static final int MINIMUM_LINE_NAME_SIZE = 2;
    private static final String LINE_IN_KOREAN = "선";
    
    private String name;

    private LineName(String name) {
        try {
            validateName(name);
        } catch (LineNameFormatException | LineNameLengthException e) {
            throw new SubwayApplicationException(e);
        }

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof LineName) {
            return Objects.equals(name, ((LineName) o).name);
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
