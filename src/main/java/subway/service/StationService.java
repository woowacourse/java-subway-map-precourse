package subway.service;

import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationService {

    private final Scanner scanner;
    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameAdd(scanner, category);
            StationRepository.addStation(stationName);
            OutputView.printAddMessage(category);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameDelete(scanner, category);
            StationRepository.deleteStation(stationName);
            OutputView.printDeleteMessage(category);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
