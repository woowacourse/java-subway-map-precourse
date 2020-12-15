package subway.domain;

import java.util.Objects;

public class StationName {
    private static final String NAME_LENGTH_LIMIT_ERROR = "[ERROR] 이름은 2글자 이상입니다.";
    private static final int NAME_LENGTH_LIMIT = 2;

    private String name;

    public StationName(String name) {
        if (name.length() < NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_ERROR);
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
