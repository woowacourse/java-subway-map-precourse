package subway.domain;

import subway.domain.validator.LineValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LineStations {
    private final List<Station> stations;

    private LineStations(Station start, Station end) {
        LineValidator.checkEndStationsAreDifferent(start, end);

        stations = new LinkedList<>();
        addStation(0, start);
        addStation(stations.size(), end);
    }

    public static LineStations create(Station start, Station end) {
        return new LineStations(start, end);
    }

    public void addStation(int index, Station station) {
        LineValidator.checkIsNotOnLine(stations.contains(station));
        LineValidator.checkIsValidOrder(index, stations.size());

        stations.add(index, station);
        station.onLine();
    }

    public void deleteSection(Station station) {
        LineValidator.checkIsOnLine(stations.contains(station));

        stations.remove(station);
        station.outOfLine();
    }

    public void removeAll() {
        stations.stream().forEach(Station::outOfLine);
    }

    public List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }
}

