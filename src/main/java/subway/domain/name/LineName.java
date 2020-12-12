package subway.domain.name;


import subway.exception.InvalidLineNameException;

import java.util.Objects;
import java.util.regex.Pattern;

public class LineName implements Comparable<LineName> {

    private static final String NAME_REGULAR_EXPRESSION = "^[가-힣0-9]{2,}[$선|경전철]";

    private String name;

    private LineName(String name) {
        this.name = name;
    }

    public static LineName of(String name) {
        validate(name);
        return new LineName(name);
    }

    private static void validate(String name) {

        if (!Pattern.matches(NAME_REGULAR_EXPRESSION, name)) {
            throw new InvalidLineNameException(name);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineName lineName = (LineName) o;
        return this.name.equals(lineName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(LineName o) {
        return name.compareTo(o.name);
    }
}
