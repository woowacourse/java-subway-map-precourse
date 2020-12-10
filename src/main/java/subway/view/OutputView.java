package subway.view;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class OutputView {
    private static final String PRINT_STATION_LIST_MESSAGE = "## 역 목록";
    private static final String PRINT_STATION_LIST = "[INFO] %s\n";

    private OutputView() {
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST_MESSAGE);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.printf(PRINT_STATION_LIST, name));
    }

}
