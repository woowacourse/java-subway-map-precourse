package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationSetting {
    public static void add(Scanner scanner) {
        Print.enterMessage(Constant.ENTER_STATION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        input = Exception.checkStationAdd(input);
        Station station = new Station(input);
        StationRepository.addStation(station);
        Print.infoMessage(Constant.ADD_STATION_DONE);
    }
}
