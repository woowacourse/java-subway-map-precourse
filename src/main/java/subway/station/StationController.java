package subway.station;

import subway.main.view.MainInputView;
import subway.station.view.StationInputView;
import subway.station.view.StationOutputView;

import java.util.Scanner;

public class StationController {
    private static final char ADD_STATION = '1';
    private static final char DELETE_STATION = '2';
    private static final char PRINT_STATION = '3';
    private static final char GO_BACK = 'B';

    public static void stationManagement(MainInputView mainInputView) {
        StationOutputView.printStationManagement();
        selectOption(mainInputView.selectOption(), mainInputView.getScanner());
    }

    private static void selectOption(char option, Scanner scanner) {
        StationInputView stationInputView = new StationInputView(scanner);

        if (option == ADD_STATION) {
            addNewStation(stationInputView);
        }
    }

    private static void addNewStation(StationInputView stationInputView) {
        String station = stationInputView.addStation();
        StationRepository.addStation(new Station(station));
        StationOutputView.addStationComplete();
    }
}
