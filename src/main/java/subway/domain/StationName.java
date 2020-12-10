package subway.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof StationName)) { return false; }
        StationName that = (StationName) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
