package subway.line.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import subway.line.exception.CannotFindStationInLineException;
import subway.line.exception.DuplicateStationNameInLineException;
import subway.line.exception.ShorterThanMinLineNameException;
import subway.line.exception.ShorterThanMinLineStationsSizeException;
import subway.line.exception.UpstreamDownstreamStationInputException;
import subway.station.domain.Station;

public class Line {

    public static final int MIN_NAME_SIZE = 2;
    public static final int MIN_STATIONS_SIZE = 2;

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

        if (upstreamStation.equals(downstreamStation)) {
            throw new UpstreamDownstreamStationInputException(upstreamStation.getName(),
                downstreamStation.getName());
        }

        return new Line(name, new ArrayList<>(Arrays.asList(upstreamStation, downstreamStation)));
    }

    public boolean contains(Station target) {
        return stations.contains(target);
    }

    public void addSection(int indexToInsert, Station station) {
        if (stations.contains(station)) {
            throw new DuplicateStationNameInLineException(name, station.getName());
        }

        stations.add(indexToInsert - 1, station);
    }

    public void deleteSection(Station station) {
        boolean isDeleted = stations.remove(station);

        if (!isDeleted) {
            throw new CannotFindStationInLineException(name, station.getName());
        }

        if (stations.size() < MIN_STATIONS_SIZE) {
            throw new ShorterThanMinLineStationsSizeException(station.getName());
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
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
