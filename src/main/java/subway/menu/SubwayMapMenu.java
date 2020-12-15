package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SubwayMapMenu {

    public void printSubwayMap() {
        System.out.println("## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            System.out.println("\n[ INFO ] " + line.getName());
            System.out.println("[ INFO ] ---");
            for (Station station : line.stationList()) {
                System.out.println("[ INFO ] " + station.getName());
            }
        }
        System.out.println();
    }
}
