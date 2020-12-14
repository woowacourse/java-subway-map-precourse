package subway.domain.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.input.StationManageInput;
import java.util.Scanner;
import java.util.stream.Stream;

public class StationManageController {


    StationManageInput input = new StationManageInput();

    public void processEnrollStation(Scanner scanner) {
        Station station = new Station(input.inputEnrollStation(scanner));
        StationRepository.addStation(station);
    }

    public void processDeleteStation(Scanner scanner) {
        String station = input.inputDeleteStation(scanner);
        StationRepository.deleteStation(station);
    }

    public void printAllStations() {
        Stream<Station> stationStream = StationRepository.stations().stream();
        stationStream.forEach(station -> System.out.println(station.getName()));
    }

}
