package subway.domain.name;

import java.util.Objects;

public class StationName implements Comparable<StationName> {

    private String name;

    private StationName(String name) {
        this.name = name;
    }

    public static StationName of(String name) {
        return new StationName(name);
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
