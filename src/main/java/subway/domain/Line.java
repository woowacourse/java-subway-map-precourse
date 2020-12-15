package subway.domain;

import java.util.Objects;

public final class Line {

    private final LineName name;

    private final StationRepository stations;

    public Line(final LineName name, final StationRepository stations) {
        this.name = name;
        this.stations = stations;
    }

    public Line(final String name, final String... stations) {
        this.name = new LineName(name);
        this.stations = new StationRepository().addStations(stations);
    }

    public String getName() {
        return name.getName();
    }

    public StationRepository getStations() {
        return stations;
    }

    public Line add(final int index, final String stationName) {
        return new Line(this.name, stations.addSection(index, stationName));
    }

    public Line remove(final String stationName) {
        return new Line(this.name, stations.removeSection(stationName));
    }

    public boolean contains(final String stationName) {
        return stations.contains(stationName);
    }

    public boolean equalsName(final String lineName) {
        return name.equals(new LineName(lineName));
    }

    @Override
    public boolean equals(Object checkObject) {
        if (this == checkObject) {
            return true;
        }

        if (!(checkObject instanceof Line)) {
            return false;
        }

        Line line = (Line) checkObject;

        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
