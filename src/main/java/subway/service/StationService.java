package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

import static subway.domain.MenuType.*;
import static subway.view.OutputView.printAddStationSuccessMessage;
import static subway.view.OutputView.printDeleteStationSuccessMessage;

public class StationService extends InputService {

    public boolean selectStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (STATION_ADD.isKeyEquals(menu)) {
            return addStation(scanner);
        }
        if (STATION_DELETE.isKeyEquals(menu)) {
            return deleteStation(scanner, lineStation);
        }
        if (STATION_SEARCH.isKeyEquals(menu)) {
            return printStations();
        }
        if (BACK.isKeyEquals(menu)) {
            return true;
        }
        return false;
    }

    private boolean addStation(Scanner scanner) {
        String stationName = inputAddStationName(scanner);
        if (isInputFail(stationName)) {
            return false;
        }
        StationRepository.addStation(new Station(stationName));
        printAddStationSuccessMessage();
        return true;
    }

    private boolean deleteStation(Scanner scanner, LineStationRepository lineStation) {
        String stationName = inputDeleteStationName(scanner, lineStation);
        if (isInputFail(stationName)) {
            return false;
        }
        StationRepository.deleteStation(stationName);
        printDeleteStationSuccessMessage();
        return true;
    }

    private boolean printStations() {
        StationRepository.printStations();
        return true;
    }
}