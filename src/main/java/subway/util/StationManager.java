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
                    break;
                } else if(inputString.equals("1")) {
                    addStation(scanner);
                    break;
                } else if(inputString.equals("2")) {
                    removeStation(scanner);
                    break;
                } else if(inputString.equals("3")) {
                    visitStation();
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return;
    }

    public void addStation(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_STATION_ADD);
        input = scanner.nextLine().trim();
        ErrorManager.checkNameLength(input);
        if(ErrorManager.isStationExist(input)) {
            throw new IllegalArgumentException(Constants.STATION_EXIST);
        }
        Station station = new Station(input);
        StationRepository.addStation(station);
        System.out.println(Constants.SECTION_ADD_COMPLETE);
    }

    public void removeStation(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_STATION_REMOVE);
        input = scanner.nextLine().trim();
        if(!ErrorManager.isStationExist(input)) {
            throw new IllegalArgumentException(Constants.STATION_NOT_EXIST);
        }
        boolean check = StationRepository.deleteStation(input);
        if(check) {
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
