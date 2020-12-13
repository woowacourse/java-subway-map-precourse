package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationSetting {
    public static void add(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_STATION_TO_ADD);
                String input = scanner.next();
                System.out.println();
                input = Exception.checkStationAdd(input);
                StationRepository.addStation(new Station(input));
                Print.infoMessage(Constant.ADD_STATION_DONE);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n%n");
            }
        }
    }

    public static void delete(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_STATION_TO_DELETE);
                String input = scanner.next();
                System.out.println();
                input = Exception.checkStationDelete(input);
                StationRepository.deleteStation(input);
                Print.infoMessage(Constant.DELETE_STATION_DONE);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n%n");
            }
        }
    }

    public static void lookUp() {
        Print.hashMessage(Constant.STATION_LIST_TITLE);
        StationRepository.stations().forEach(station -> {
            System.out.print(Constant.HEAD_INFO);
            System.out.println(station.getName());
        });
    }
}
