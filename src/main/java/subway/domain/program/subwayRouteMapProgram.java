package subway.domain.program;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class subwayRouteMapProgram {

    static final String SUBWAY_ROUTE_MAP = "## 지하철 노선도";
    static final String INFO = "[INFO] ";
    static final String DIVISION_LINE = "---";

    public void printStations(Line line) {
        System.out.println(INFO + line.getName());
        System.out.println(INFO + DIVISION_LINE);
        for (Station station : line.getStation()) {
            System.out.println(INFO + station.getName());
        }
    }

    public void printLineAndStation() {
        System.out.println(SUBWAY_ROUTE_MAP);
        for (Line line : LineRepository.lines()) {
            printStations(line);
            System.out.println();
        }
    }
}
