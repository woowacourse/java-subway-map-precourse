package subway.view;

import subway.Constants;
import subway.domain.*;

public class OutputView {

    public static void printStation() {
        System.out.println(Constants.STATION_LIST);
        for (Station station : StationRepository.stations()) {
            System.out.println(station);
        }
        System.out.println();
    }

    public static void printLine() {
        System.out.println(Constants.LINE_LIST);
        for (Line line : LineRepository.lines()) {
            System.out.println(line.toString());
        }
        System.out.println();
    }

    public static void printLineAndStation() {
        for (Line line : LineRepository.lines()) {
            System.out.println(line.toString() + Constants.INFORMATION_BAR);
            for (Station station : line.getStations()) {
                System.out.println(station.toString());
            }
            System.out.println();
        }
    }
}
