package subway.domain;

import java.util.Objects;

public class Line {

    public static final String DUPLICATE_FINAL_STATION = "상행 종점역과 하행 종점역이 일치합니다. 서로 다른 역을 입력해주세요.";

    private final LineName name;

    private final StationRepository stations;

    public Line(String name, String startStation, String finalStation) {
        if (startStation.equals(finalStation)) {
            throw new IllegalArgumentException(DUPLICATE_FINAL_STATION);
        }

        this.name = new LineName(name);
        this.stations = new StationRepository(startStation, finalStation);
    }

    public Line(LineName name, StationRepository stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name.getName();
    }

    public Line insertStation(int index, String stationName) {
        return new Line(this.name, stations.insertStation(index, stationName));
    }

    public Line remove(String stationName) {
        return new Line(this.name, stations.deleteStation(stationName));
    }

    public boolean contains(String stationName) {
        return stations.contains(stationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Line)) { return false; }
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
