package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationSetting {
    public static void add(Scanner scanner) {
                Print.hashMessage(Constant.ENTER_STATION_TO_ADD);
                String input = scanner.next();
                System.out.println();
                input = Exceptions.checkStationAdd(input);
                StationRepository.addStation(new Station(input));
                Print.infoMessage(Constant.ADD_STATION_DONE);
    }

    public static void delete(Scanner scanner) {
                Print.hashMessage(Constant.ENTER_STATION_TO_DELETE);
                String input = scanner.next();
                System.out.println();
                input = Exceptions.checkStationDelete(input);
                StationRepository.deleteStation(input);
                Print.infoMessage(Constant.DELETE_STATION_DONE);
    }

    public static void lookUp() {
        Print.hashMessage(Constant.STATION_LIST_TITLE);
        StationRepository.stations().forEach(station -> {
            System.out.print(Constant.HEAD_INFO);
            System.out.println(station.getName());
        });
    }
}
