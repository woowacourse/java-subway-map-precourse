package subway.domain;

import java.util.List;

public class LineStation {
    public static final int MIN_LINE_IN_SECTION_SIZE = 2;

    private Line line;
    private List<Station> stations;

    public LineStation(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean contains(Station findStation) {
        return stations.stream()
                .anyMatch(station -> station.equals(findStation));
    }
}
