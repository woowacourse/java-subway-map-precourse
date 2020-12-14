package subway.function.station.management;

import subway.domain.station.StationRepository;

public class PrintAllStationsList {
    public static void printAllStationsList() {
        StationRepository.printAll();
    }
}
