package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.Stations;

import java.util.List;
import java.util.stream.Collectors;

public class Section {
    private final Line line;
    private final Stations stations;

    private Section(Line line, Stations stations) {
        this.line = line;
        this.stations = stations;
    }

    public static Section of(Line line, Stations stations) {
        return new Section(line, stations);
    }

    public String getLineName() {
        return line.getName();
    }

    public List<String> getStationsName() {
        return stations.getStations().stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
