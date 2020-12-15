package subway.station;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.Line;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class SubwayUtils {
    private Scanner scanner;

    public SubwayUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        showSubwayMap();
    }

    public void showSubwayMap() {
        List<Line> lines = LineRepository.lines();
        System.out.println();
        for (Line line : lines) {
            List<Station> stations = line.showStations();

            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            for (Station station : stations) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println("");
        }
    }
}
