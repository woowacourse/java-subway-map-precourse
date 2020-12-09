package subway.domain.line;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import subway.domain.line.exception.ShorterThanMinLineNameException;
import subway.domain.station.Station;

public class Line {

    public static final int MIN_NAME_SIZE = 2;

    private String name;
    private List<Station> stations;

    private Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static Line of(String name, Station upstreamStation, Station downstreamStation) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinLineNameException(name);
        }

        return new Line(name, Arrays.asList(upstreamStation, downstreamStation));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
