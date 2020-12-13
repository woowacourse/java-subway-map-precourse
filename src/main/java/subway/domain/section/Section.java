package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.Stations;

import java.util.List;
import java.util.stream.Collectors;

public class Section implements Comparable<Section> {
    private final Line line;
    private final Stations stations;

    private Section(Line line, Stations stations) {
        this.line = line;
        this.stations = stations;
    }

    public static Section of(Line line, Stations stations) {
        return new Section(line, stations);
    }

    public void addStation(Station station, int sequence) {
        stations.addStation(station, sequence);
    }

    public String getLineName() {
        return line.getName();
    }

    public int getStationsLength() {
        return stations.size();
    }

    public List<String> getStationsName() {
        return stations.getStations().stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
    public boolean deleteStationByStation(Station station) {
        return stations.deleteStation(station);
    }

    @Override
    public int compareTo(Section o) {
        if (this.line.getName().compareTo(o.line.getName()) > 0) {
            return 1;
        }
        return -1;
    }
}
