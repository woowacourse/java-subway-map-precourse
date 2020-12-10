package subway.domain;

import java.util.Objects;

public class Station {
    private static final int ZERO = 0;
    private String name;
    private int lineCount = 0;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name){
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    public void addLine() {
        lineCount++;
    }

    public void removeLine() {
        lineCount--;
    }

    public boolean isRemovable() {
        return lineCount == ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return getName().equals(station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
