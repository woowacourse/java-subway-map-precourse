package subway.domain;

import java.util.Objects;

public class StationName {
    private String name;

    public StationName(String name) {
        if (name.length() < Constants.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_LIMIT_ERROR);
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StationName) {
            StationName anotherName = (StationName) object;
            return name.equals(anotherName.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
