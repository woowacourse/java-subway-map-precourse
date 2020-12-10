package subway.domain;

import java.util.Objects;

public class Line {

    public static final String DUPLICATE_FINAL_STATION = "상행 종점역과 하행 종점역이 일치합니다. 서로 다른 역을 입력해주세요.";

    private final StationRepository stations;

    private final LineName name;

    public Line(String name, String startStation, String finalStation) {
        if (startStation.equals(finalStation)) {
            throw new IllegalArgumentException(DUPLICATE_FINAL_STATION);
        }

        this.name = new LineName(name);
        this.stations = new StationRepository(startStation, finalStation);
    }

    public String getName() {
        return name.getName();
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
