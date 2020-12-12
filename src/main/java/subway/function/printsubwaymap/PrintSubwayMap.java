package subway.function.printsubwaymap;

import subway.domain.LineStationMappingRepository;

public class PrintSubwayMap {
    public static void start() {
        printAllSubwayMap();
    }

    private static void printAllSubwayMap() {
        PrintSubwayMapPrinter.printSubwayMapTitle();
        LineStationMappingRepository.printAllSubwayMap();
    }
}
