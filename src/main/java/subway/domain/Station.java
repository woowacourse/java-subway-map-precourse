package subway.domain;

public class Station {
    private Name name;

    public Station(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isSameName(Name name) {
        return this.name.equals(name);
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
