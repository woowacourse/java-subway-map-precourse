package subway.line.domain;

import java.util.List;
import subway.line.exception.CannotFindStationInLineException;
import subway.station.domain.Station;

public class LineStations {

    private final List<LineStation> lineStations;

    public LineStations(List<LineStation> lineStations) {
        this.lineStations = lineStations;
    }

    public boolean contains(Station targetStation) {
        for (LineStation lineStation : lineStations) {
            if (lineStation.getStation().equals(targetStation)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return lineStations.size();
    }

    public void add(int indexToInsert, Station station) {
        if (lineStations.size() == indexToInsert - 1) {
            LineStation lastLineStation = lineStations.get(lineStations.size() - 1);
            LineStation newLineStation = LineStation.of(station, lastLineStation.getStation());
            lineStations.add(newLineStation);
            return;
        }

        LineStation originalLineStation = lineStations.get(indexToInsert - 1);
        LineStation newLineStation = LineStation.of(station, originalLineStation.getPrevStation());
        originalLineStation.setPrevStation(station);
        lineStations.add(indexToInsert - 1, newLineStation);
    }

    public void remove(Station station) {
        LineStation targetLineStation = getTargetLineStation(station);
        lineStations.stream()
            .filter(lineStation ->
                lineStation.getPrevStation() != null && lineStation.getPrevStation().equals(station))
            .findAny()
            .ifPresent(lineStation -> lineStation.setPrevStation(targetLineStation.getPrevStation()));

        lineStations.remove(targetLineStation);
    }

    private LineStation getTargetLineStation(Station station) {
        return lineStations.stream()
            .filter(lineStation -> lineStation.getStation().equals(station))
            .findAny()
            .orElseThrow(() -> {
                throw new CannotFindStationInLineException(station.getName());
            });
    }

    public List<LineStation> getLineStations() {
        return lineStations;
    }
}
