package subway.domain;

import java.util.List;

public class Section {
    private Line line;
    private List<Station> stations;

    public Section(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }
}
