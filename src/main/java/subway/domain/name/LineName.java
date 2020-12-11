package subway.domain.name;


import subway.exception.InvalidLineNameException;

import java.util.Objects;

public class LineName implements Comparable<LineName> {

    private static final int ONE_INDEX = 1;
    private static final int NAME_MIN_LENGTH = 3;  //마지막 "역"까지 포함해서 3글자 이상
    private static final char NAME_SUFFIX = '선';

    private String name;

    private LineName(String name) {
        this.name = name;
    }

    public static LineName of(String name) {
        return new LineName(name);
    }

    private static void validate(String name) {

        if (name.length() > NAME_MIN_LENGTH) {
            throw new InvalidLineNameException(name);
        }

        if (!containSuffix(name)) {
            throw new InvalidLineNameException(name);
        }

    }

    private static boolean containSuffix(String name) {
        return name.charAt(LastIndexOf(name)) == NAME_SUFFIX;
    }

    private static int LastIndexOf(String name) {
        return name.length() - ONE_INDEX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineName lineName = (LineName) o;
        return Objects.equals(name, lineName.name);
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
