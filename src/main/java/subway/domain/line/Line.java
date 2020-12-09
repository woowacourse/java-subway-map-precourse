package subway.domain.line;

import subway.domain.line.exception.ShorterThanMinLineNameException;

public class Line {

    public static final int MIN_NAME_SIZE = 2;

    private String name;

    private Line(String name) {
        this.name = name;
    }

    public static Line from(String name) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinLineNameException(name);
        }

        return new Line(name);
    }

    public String getName() {
        return name;
    }
}
