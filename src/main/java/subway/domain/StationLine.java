package subway.domain;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class StationLine {
    private Line line;
    private Station station;

    private StationLine(Line line, Station station) {
        this.line = line;
        this.station = station;
    }

    public static StationLine of(Line line, Station station) {
        return new StationLine(line, station);
    }
}
