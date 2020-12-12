package subway.line;

import subway.line.domain.Line;
import subway.line.domain.Route;
import subway.station.domain.Station;

public class LineCreator {
    private LineCreator() {
    }

    public static Line createLine(String lineName, Station topStation, Station bottomStation) {
        Line line = new Line(lineName, new Route(topStation, bottomStation));
        topStation.addLine(line);
        bottomStation.addLine(line);
        return line;
    }
}
