package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class OutputView {

    public static void printLines() {
        LineRepository.lines().stream()
                .forEach(line -> System.out.println("[INFO] " + line.getName()));
        System.out.println();
    }

    public static void printStations() {
        StationRepository.stations().stream()
                .forEach(station -> System.out.println("[INFO] " + station.getName()));
        System.out.println();
    }
}
