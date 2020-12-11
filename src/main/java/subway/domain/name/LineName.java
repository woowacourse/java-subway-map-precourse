package subway.domain.name;


import java.util.Objects;

public class LineName implements Comparable<LineName> {

    private String name;

    private LineName(String name) {
        this.name = name;
    }

    public static LineName of(String name) {
        return new LineName(name);
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
