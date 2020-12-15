package subway.service;

import subway.controller.StationMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationService {
    private static final String DUPLICATED_STATION_NAME_MESSAGE = "\n[ERROR] 해당 역은 이미 등록되었습니다.";
    private static final String NOT_EXIST_TO_DELETE_MESSAGE = "\n[ERROR] 삭제할 역이 존재하지 않습니다.";
    private static final String CANNOT_DELETE_LINE_REGISTERED_STATION = "\n[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";

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
            stationMenuController.mappingMenu(scanner);
        }
    }

    private void isDuplicatedStation(Station station) {
        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME_MESSAGE);
        }
    }

    public void stationDeleteService() {
        try {
            String stationNameToDelete = StationInputView.inputStationName(scanner);
            isNotExistStation(new Station(stationNameToDelete));
            isLineRegisteredStation(stationNameToDelete);
            StationRepository.deleteStation(stationNameToDelete);
            StationOutputView.printDeleteSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenuController stationMenuController = StationMenuController.getInstance();
            stationMenuController.mappingMenu(scanner);
        }
    }

    private void isNotExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_TO_DELETE_MESSAGE);
        }
    }

    private void isLineRegisteredStation(String stationNameToDelete) {
        if (LineRepository.lines().stream().map(Line::getStations).anyMatch(station -> station.contains(new Station(stationNameToDelete)))) {
            throw new IllegalArgumentException(CANNOT_DELETE_LINE_REGISTERED_STATION);
        }
    }

    public void showAllStations() {
        StationOutputView.printStations(StationRepository.stations());
    }
}
