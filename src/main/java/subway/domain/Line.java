package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private Stations stations = new Stations();

    public Line(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        this.name = name;
        this.stations.addStation(uplineTerminalStation);
        this.stations.addStation(downlineTerminalStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(int index, Station station) {
        if (!stations.isPresentStation(station)) {
            stations.addStation(index, station);
            return;
        }

        throw new SubwayException(ERR_ALREADY_ADD_STATION_NAME_MSG);
    }

    public void deleteStation(String name) {
        if (stations.size() <= STATION_MINIMUM_SIZE) {
            throw new SubwayException(ERR_POOR_SIZE_OF_STATION_MSG);
        }
        stations.deleteStation(name);
    }

    public int size() {
        return stations.size();
    }

    public List<String> stationsNames() {
        return stations.stationNames();
    }

    public List<String> unorderedStationNames() {
        return stations.unorderedStationNames();
    }

    public boolean containsStation(Station station) {
        return stations.isPresentStation(station);
    }

    public Station findStation(String stationName) {
        return stations.findStation(stationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
