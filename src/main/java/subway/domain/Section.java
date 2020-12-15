package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private Line line;
    private List<Station> stations;

    public Section(Line line) {
        this.line = line;
        this.stations = new ArrayList<>();
    }

    public Section(Line line, Station upwardStation, Station downwardStation) {
        this.line = line;
        this.stations = new ArrayList<>();
        this.stations.add(upwardStation);
        this.stations.add(downwardStation);
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(int index, Station station) {
        stations.add(index, station);
    }
}
