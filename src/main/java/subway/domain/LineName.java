package subway.domain;
/*
 * LineName
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import java.util.Objects;

public class LineName {
    private String name;

    public LineName(String name) {
        if (name.length() < Constants.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_LIMIT_ERROR);
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LineName) {
            LineName anotherName = (LineName) object;
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
