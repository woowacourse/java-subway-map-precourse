package subway.station;

import subway.main.view.MainInputView;
import subway.station.view.StationInputView;
import subway.station.view.StationOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StationController {
    private static final char ADD_STATION = '1';
    private static final char DELETE_STATION = '2';
    private static final char PRINT_STATION = '3';
    private static final char GO_BACK = 'B';

    public static void stationManagement(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(ADD_STATION, DELETE_STATION, PRINT_STATION, GO_BACK);

        StationOutputView.printStationManagement();
        selectOption(mainInputView.selectOption(optionList), mainInputView.getScanner());
    }

    private static void selectOption(char option, Scanner scanner) {
        StationInputView stationInputView = new StationInputView(scanner);

        if (option == ADD_STATION) {
            addNewStation(stationInputView);
        }
    }

    private static void addNewStation(StationInputView stationInputView) {
        Station station;
        String stationName = stationInputView.addStation();
        try {
            station = new Station(stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        StationRepository.addStation(station);
        StationOutputView.addStationComplete();
    }
}
