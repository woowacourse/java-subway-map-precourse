package subway.station;

import subway.common.SelectOption;
import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;
import subway.view.InputView;
import subway.view.station.StationManagementView;

import java.util.Arrays;
import java.util.List;

public class StationController {
    private static final char ADD_STATION = '1';
    private static final char DELETE_STATION = '2';
    private static final char PRINT_STATION = '3';
    private static final char GO_BACK = 'B';

    public static void stationManagement(InputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_STATION, DELETE_STATION, PRINT_STATION, GO_BACK);

        while (true) {
            StationManagementView.showStationManagementMenu();
            char option = SelectOption.choice(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, InputView inputView) {
        try {
            if (option == ADD_STATION) {
                return addNewStation(inputView);
            }
            if (option == DELETE_STATION) {
                return deleteStation(inputView);
            }
            if (option == PRINT_STATION) {
                return printRegisteredStation();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean addNewStation(InputView inputView) {
        StationManagementView.askNewStationName();
        String stationName = inputView.stationName();

        Station station = new Station(stationName);
        StationService.addStation(station);

        StationManagementView.addStationComplete();
        return true;
    }

    private static boolean deleteStation(InputView inputView) {
        StationManagementView.askDeleteStationName();
        String stationName = inputView.stationName();

        CheckRegisteredStation.validation(stationName);
        CheckStationRegisteredLine.validation(stationName);
        StationService.deleteStation(stationName);

        StationManagementView.deleteStationComplete();
        return true;
    }

    private static boolean printRegisteredStation() {
        List<Station> stations = StationService.AllStation();
        StationManagementView.printAllStation(stations);
        return true;
    }
}
