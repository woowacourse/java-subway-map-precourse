package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SubwayMapMenu {

    public void printSubwayMap() {
        System.out.println("## 지하철 노선도");
        printLines();
        System.out.println();
    }

    private void printLines() {
        for (Line line : LineRepository.lines()) {
            System.out.println("\n[ INFO ] " + line.getName());
            System.out.println("[ INFO ] ---");
            printStations(line);
        }
    }

    private void printStations(Line line) {
        for (Station station : line.stationList()) {
            System.out.println("[ INFO ] " + station.getName());
        }
    }
}
