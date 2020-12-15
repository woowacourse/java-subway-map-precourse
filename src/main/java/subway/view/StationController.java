package subway.view;

import subway.Constant;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationController {
    Scanner scanner;
    StationRepository stationRepository = new StationRepository();

    public StationController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printSelection() {
        System.out.println(Constant.STATION_ANNOUNCEMENT);
        String command = scanner.next();
        if (command.equals(Constant.FIRST_COMMAND)) {
            addStation();
        } else if (command.equals(Constant.SECOND_COMMAND)) {
            deleteStation();
        } else if (command.equals(Constant.THIRD_COMMAND)) {
            readStations();
        } else if (command.equals(Constant.BACK_COMMAND)) {
            return;
        }
    }

    void addStation() {
        System.out.println(String.join(" 역 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String stationName = scanner.next();
        Station station = new Station(stationName);
        stationRepository.addStation(station);
    }

    void deleteStation() {
        System.out.println(String.join(" 역 ", Constant.DELETE_PREFIX, Constant.NAME_POSTFIX));
        String stationName = scanner.next();
        boolean deleteFlag = stationRepository.deleteStation(stationName);
        if (deleteFlag) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.DELETE_STATION_SUCCESS));
        }
    }

    void readStations() {
        stationRepository.printStations();
    }
}
