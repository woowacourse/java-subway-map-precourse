package subway.domain;

import subway.validator.StationNameValidator;

public class StationName {

    public static final int LENGTH_LOWER_BOUND = 2;

    public static final int LENGTH_UPPER_BOUND = 10;

    private final String name;

    public StationName(String name) {
        new StationNameValidator().validate(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
