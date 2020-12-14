package subway.util;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class StationManager {
    public void stationMain(Scanner scanner) {
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
        return;
    }

    public void addStation(Scanner scanner) {
        String input;
        System.out.println(Constants.ASK_STATION_ADD);
        input = scanner.nextLine().trim(); // 에러 처리
        Station station = new Station(input);
        StationRepository.addStation(station);
    }

    public void removeStation(Scanner scanner) {
        String input;
        System.out.println(Constants.ASK_STATION_REMOVE);
        input = scanner.nextLine().trim(); // 에러 처리
        boolean check = StationRepository.deleteStation(input);
        if(check) {
            System.out.println(Constants.STATION_REMOVE_COMPLETE);
        } else {
            System.out.println(Constants.STATION_REMOVE_FAIL);
        }
    }

    public void visitStation() {
        for(Station station : StationRepository.stations()) {
            System.out.println(station.getName());
        }
    }
}
