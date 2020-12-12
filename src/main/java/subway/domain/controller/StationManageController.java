package subway.domain.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.input.StationManageInput;
import java.util.Scanner;
import java.util.stream.Stream;

public class StationManageController {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    StationManageInput input = new StationManageInput();

    public void processEnrollStation(Scanner scanner) {
        if (input.inputStationManageScreen(scanner).equals(FUNCTION_ONE)) {
            Station station = new Station(input.inputEnrollStation(scanner));
            StationRepository.addStation(station);
        }
    }

    public void processDeleteStation(Scanner scanner) {
        if (input.inputStationManageScreen(scanner).equals(FUNCTION_TWO)) {
            String station = input.inputDeleteStation(scanner);
            StationRepository.deleteStation(station);
        }
    }

    public void printAllStations(Scanner scanner) {
        if (input.inputStationManageScreen(scanner).equals(FUNCTION_THREE)) {
            Stream<Station> stationStream = StationRepository.stations().stream();
            stationStream.forEach(station -> System.out.println(station.getName()));
        }
    }

    public boolean processGoBack(Scanner scanner) {
        return input.inputStationManageScreen(scanner).equals(FUNCTION_BACK);
    }

}
