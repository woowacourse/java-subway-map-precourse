package subway.domain.entity;

import java.util.Objects;

public class Line {
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;

    private final String name;

    public Line(String name) {
        validateLineName(name);
        this.name = name;
    }

    private void validateLineName(String name) {
        if (Objects.isNull(name)) {
            throw new LineNameException();
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_LINE_NAME_LENGTH) {
            throw new LineNameException();
        }
    }

    public String getName() {
        return name;
    }
}
