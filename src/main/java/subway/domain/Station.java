package subway.domain;

import java.util.Objects;

public class Station {
    private String name;
    private boolean isRegistered;

    public Station(String name) {
        this.name = name;
        this.isRegistered = false;
    }

    public String getName() {
        return name;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
