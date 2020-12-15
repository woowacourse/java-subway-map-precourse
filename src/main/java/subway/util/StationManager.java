package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationManager {
    public void stationMain(Scanner scanner) {
        while(true) {
            try {
                Constants.printStation();
                String inputString = scanner.nextLine().trim();
                if(inputString.equals("B")) {
                    return;
                } else if(inputString.equals("1")) {
                    addStation(scanner);
                } else if(inputString.equals("2")) {
                    removeStation(scanner);
                } else if(inputString.equals("3")) {
                    visitStation();
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void addStation(Scanner scanner) throws IllegalArgumentException {
        System.out.println(Constants.ASK_STATION_ADD);
        String input = scanner.nextLine().trim();
        ErrorManager.checkNameLength(input);
        if(ErrorManager.isStationExist(input)) {
            throw new IllegalArgumentException(Constants.STATION_EXIST);
        }
        Station station = new Station(input);
        StationRepository.addStation(station);
        System.out.println(Constants.STATION_ADD_COMPLETE);
    }

    public void removeStation(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_STATION_REMOVE);
        input = scanner.nextLine().trim();
        if(!(ErrorManager.isStationExist(input))) {
            throw new IllegalArgumentException(Constants.STATION_NOT_EXIST);
        }
        if(StationRepository.deleteStation(input)) {
            System.out.println(Constants.STATION_REMOVE_COMPLETE);
        } else {
            throw new IllegalArgumentException(Constants.STATION_REMOVE_FAIL);
        }
    }

    public void visitStation() {
        System.out.println(Constants.STATION_LIST);
        for(Station station : StationRepository.stations()) {
            System.out.println(station.getName());
        }
    }
}
