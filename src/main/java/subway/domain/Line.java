package subway.domain;

import subway.global.validator.Validator;

public class Line {
    private static final int MIN_LENGTH = 2;
    private String name;

    public Line(String name) {
        Validator.validateMinLength(name, MIN_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
