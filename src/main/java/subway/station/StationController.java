package subway.station;

import subway.common.CommonService;
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
            char option = CommonService.selectOption(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, InputView inputView) {
        if (option == ADD_STATION) {
            return addNewStation(inputView);
        }
        if (option == DELETE_STATION) {
            return deleteStation(inputView);
        }
        if (option == PRINT_STATION) {
            return printRegisteredStation();
        }
        return false;
    }

    private static boolean addNewStation(InputView inputView) {
        StationManagementView.askNewStationName();
        String stationName = inputView.stationName();
        boolean success = StationService.addStation(stationName);
        if (success) {
            StationManagementView.addStationComplete();
        }
        return success;
    }

    private static boolean deleteStation(InputView inputView) {
        StationManagementView.askDeleteStationName();
        String stationName = inputView.stationName();
        boolean success = StationService.deleteStation(stationName);
        if (success) {
            StationManagementView.deleteStationComplete();
        }
        return success;
    }

    private static boolean printRegisteredStation() {
        return StationService.printAllStation();
    }
}
