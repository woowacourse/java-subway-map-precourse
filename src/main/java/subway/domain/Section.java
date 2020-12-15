package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private Line line;
    private List<Station> station = new ArrayList<>();

    public Section(Line line) {
        this.line = line;
    }

    public void addStation(int index, Station station) {
        this.station.add(index, station);
    }

    public void addStation(Station station) { this.station.add(station); }

    public Line getLine() {
        return line;
    }

    public List<Station> getStation() {
        return this.station;
    }


}
