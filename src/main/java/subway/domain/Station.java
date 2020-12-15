package subway.domain;

public class Station {
    private final Name name;

    public Station(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        boolean isEqualObject = false;
        Station station = (Station) object;
        if (getName().equals(station.getName())) {
            isEqualObject = true;
        }
        return isEqualObject;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + getName().hashCode();
        return hashCode;
    }
}
