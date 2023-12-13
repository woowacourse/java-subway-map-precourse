package subway.domain;

import subway.global.validator.Validator;

public class Station {
    private static final int MIN_LENGTH = 2;
    private String name;

    public Station(String name) {
        Validator.validateMinLength(name, MIN_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
