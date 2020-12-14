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

        while (true) {
            StationOutputView.printStationManagement();
            char option = mainInputView.selectOption(optionList);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, mainInputView.getScanner())) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, Scanner scanner) {
        StationInputView stationInputView = new StationInputView(scanner);

        if (option == ADD_STATION) {
            return addNewStation(stationInputView);
        }
        if (option == DELETE_STATION) {
            return deleteStation(stationInputView);
        }
        if (option == PRINT_STATION) {
            return printRegisteredStation();
        }
        return false;
    }

    private static boolean addNewStation(StationInputView stationInputView) {
        String stationName = stationInputView.addStation();
        return StationService.addStation(stationName);
    }

    private static boolean deleteStation(StationInputView stationInputView) {
        String stationName = stationInputView.deleteStation();
        return StationService.deleteStation(stationName);
    }

    private static boolean printRegisteredStation() {
        return StationService.printAllStation();
    }
}
