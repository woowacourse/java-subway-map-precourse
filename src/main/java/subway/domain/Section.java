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
        if(index > this.station.size()) { index = this.station.size(); }
        if(index <= 0) { index = 1; }
        this.station.add(index-1, station);
    }

    public void addStation(Station station) { this.station.add(station); }

    public Line getLine() { return line; }

    public List<Station> getStation() { return this.station; }
}
