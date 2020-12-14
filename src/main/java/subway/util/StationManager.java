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

        return;
    }

    public void addStation(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_STATION_ADD);
        input = scanner.nextLine().trim();
        ErrorManager.checkNameLength(input);
        Station station = new Station(input);
        StationRepository.addStation(station);
    }

    public IllegalArgumentException removeStation(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_STATION_REMOVE);
        input = scanner.nextLine().trim(); // 에러 처리
        ErrorManager.isStationExist(input);
        boolean check = StationRepository.deleteStation(input);
        if(check) {
            System.out.println(Constants.STATION_REMOVE_COMPLETE);
        } else {
            return new IllegalArgumentException(Constants.STATION_REMOVE_FAIL);
        }
        return null;
    }

    public void visitStation() {
        for(Station station : StationRepository.stations()) {
            System.out.println(station.getName());
        }
    }
}
