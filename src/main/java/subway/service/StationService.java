package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

import static subway.domain.MenuType.*;
import static subway.view.OutputView.printAddStationSuccessMessage;
import static subway.view.OutputView.printDeleteStationSuccessMessage;

public class StationService extends InputService {

    public void selectStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (STATION_ADD.isKeyEquals(menu)) {
            addStation(scanner);
        }
        if (STATION_DELETE.isKeyEquals(menu)) {
            deleteStation(scanner, lineStation);
        }
        if (STATION_SEARCH.isKeyEquals(menu)) {
            printStations();
        }
    }

    private void addStation(Scanner scanner) {
        String stationName = inputAddStationName(scanner);
        StationRepository.addStation(new Station(stationName));
        printAddStationSuccessMessage();
    }

    private void deleteStation(Scanner scanner, LineStationRepository lineStation) {
        String stationName = inputDeleteStationName(scanner, lineStation);
        StationRepository.deleteStation(stationName);
        printDeleteStationSuccessMessage();
    }

    private void printStations() {
        StationRepository.printStations();
    }
}