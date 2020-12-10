package subway.line.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import subway.line.exception.DuplicateStationNameInLineException;
import subway.line.exception.ShorterThanMinLineNameException;
import subway.line.exception.ShorterThanMinLineStationsSizeException;
import subway.line.exception.UpstreamDownstreamStationInputException;
import subway.station.domain.Station;

public class Line {

    public static final int MIN_NAME_SIZE = 2;
    public static final int MIN_STATIONS_SIZE = 2;

    private final String name;
    private final LineStations lineStations;

    private Line(String name, List<LineStation> lineStations) {
        this.name = name;
        this.lineStations = new LineStations(lineStations);
    }

    public static Line of(String name, Station upstreamStation, Station downstreamStation) {
        checkAddLineValidation(name, upstreamStation, downstreamStation);

        LineStation upstreamLineStation = LineStation.from(upstreamStation);
        LineStation downstreamLineStation = LineStation.of(downstreamStation, upstreamStation);

        return new Line(name, new ArrayList<>(Arrays.asList(upstreamLineStation, downstreamLineStation)));
    }

    private static void checkAddLineValidation(String name, Station upstreamStation, Station downstreamStation) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinLineNameException(name);
        }

        if (upstreamStation.equals(downstreamStation)) {
            throw new UpstreamDownstreamStationInputException(upstreamStation.getName(),
                downstreamStation.getName());
        }
    }

    public boolean contains(Station target) {
        return lineStations.contains(target);
    }

    public void addSection(int indexToInsert, Station station) {
        if (lineStations.contains(station)) {
            throw new DuplicateStationNameInLineException(name, station.getName());
        }

        lineStations.add(indexToInsert, station);
    }

    public void deleteSection(Station station) {
        lineStations.remove(station);
        checkDeleteSectionValidation(station);
    }

    private void checkDeleteSectionValidation(Station station) {
        if (lineStations.size() < MIN_STATIONS_SIZE) {
            throw new ShorterThanMinLineStationsSizeException(station.getName());
        }
    }

    public String getName() {
        return name;
    }

    public List<LineStation> getLineStations() {
        return lineStations.getLineStations();
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
