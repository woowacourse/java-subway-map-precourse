package subway.domain;

import java.util.Objects;

public class Station {
    private static final int VALID_LENGTH = 2;

    private String name;

    public Station(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String userInput) {
        if (!(userInput.length() >= VALID_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }
}
