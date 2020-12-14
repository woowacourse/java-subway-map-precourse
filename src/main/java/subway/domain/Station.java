package subway.domain;

import subway.domain.exception.WrongAccessException;

public class Station {
    private Name name;
    private int countOnLine;

    private Station(Name name) {
        this.name = name;
    }

    public static Station create(Name name) {
        return new Station(name);
    }

    public boolean isSameName(Name name) {
        return this.name.equals(name);
    }

    public void onLine() {
        countOnLine++;
    }

    public void outOfLine() {
        if (countOnLine <= 0) {
            throw new WrongAccessException();
        }
        countOnLine--;
    }

    public boolean isOnLine() {
        return countOnLine > 0;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Station) {
            return ((Station) o).name.equals(this.name);
        }
        return false;
    }
}
