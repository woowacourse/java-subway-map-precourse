package subway.service;

import subway.controller.StationMenuController;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationService {
    private static final String DUPLICATED_STATION_NAME_MESSAGE = "\n[ERROR] 해당 역은 이미 등록되었습니다.";
    private static final String NOT_EXIST_TO_DELETE_MESSAGE = "\n[ERROR] 삭제할 역이 존재하지 않습니다.";
    final Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void stationAddService() {
        try {
            String inputName = StationInputView.inputStationName(scanner);
            Station newStation = new Station(inputName);
            isDuplicatedStation(newStation);
            StationRepository.addStation(newStation);
            StationOutputView.printAddSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenuController stationMenuController = StationMenuController.getInstance();
            stationMenuController.mappingStationMenu(scanner);
        }
    }

    private void isDuplicatedStation(Station station) {
        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME_MESSAGE);
        }
    }

    public void stationDeleteService() {
        try {
            String inputName = StationInputView.inputStationName(scanner);
            isNotExistStation(new Station(inputName));
            StationRepository.deleteStation(inputName);
            StationOutputView.printDeleteSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenuController stationMenuController = StationMenuController.getInstance();
            stationMenuController.mappingStationMenu(scanner);
        }
    }

    private void isNotExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_TO_DELETE_MESSAGE);
        }
    }

    public void showAllStations() {
        StationOutputView.printStations(StationRepository.stations());
    }
}
