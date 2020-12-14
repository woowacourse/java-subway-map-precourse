package subway.domain.name;

import subway.exception.InvalidStationNameException;

import java.util.Objects;
import java.util.regex.Pattern;

public class StationName implements Comparable<StationName> {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int ONE_INDEX = 1;
    private static final char NAME_SUFFIX = '역';
    private static final String NAME_REGULAR_EXPRESSION = "^[가-힣]{2,}[$역]";

    private String name;


    private StationName(String name) {
        this.name = name;
    }

    public static StationName of(String name) {
        validate(name);
        return new StationName(name);
    }

    private static void validate(String name) {

        if (name.length() < NAME_MIN_LENGTH) {
            throw new InvalidStationNameException(name);
        }

        if (!containSuffix(name)) {
            throw new InvalidStationNameException(name);
        }

        if (!isKorean(name)) {
            throw new InvalidStationNameException(name);
        }

    }

    private static boolean isKorean(String name) {
        return Pattern.matches(NAME_REGULAR_EXPRESSION, name);
    }

    private static boolean containSuffix(String name) {
        return name.charAt(lastIndexOf(name)) == NAME_SUFFIX;
    }

    private static int lastIndexOf(String name) {
        return name.length() - ONE_INDEX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationName that = (StationName) o;
        return Objects.equals(name, that.name);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(StationName o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
