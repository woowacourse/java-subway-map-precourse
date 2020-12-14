package subway.domain.station;

import java.util.Objects;

public class Station {
    private StationName name;

    private Station(StationName name) {
        this.name = name;
    }

    public static Station of(StationName name) {
        return new Station(name);
    }

    public StationName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Station) {
            return Objects.equals(((Station) o).name, this.name);
        }

        return false;
    }
}
