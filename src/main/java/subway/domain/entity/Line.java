package subway.domain.entity;

import java.util.Objects;

public class Line {
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;

    private final String name;
    private final Sections sections;

    public Line(String name, Sections sections) {
        validateLineName(name);
        this.name = name;
        this.sections = sections;
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

    public boolean matchesName(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }
}
