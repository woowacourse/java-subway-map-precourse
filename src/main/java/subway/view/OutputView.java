package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class OutputView {

    public static void printStations() {
        StationRepository.stations().stream()
                .forEach(station -> System.out.println(station.getName()));
        System.out.println();
    }
    
}
