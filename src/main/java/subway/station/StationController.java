package subway.station;

import subway.main.view.MainInputView;
import subway.station.view.StationOutputView;

public class StationController {
    private static final char ADD_STATION = '1';
    private static final char DELETE_STATION = '2';
    private static final char PRINT_STATION = '3';
    private static final char GO_BACK = 'B';

    public static void stationManagement(MainInputView mainInputView) {
        StationOutputView.printStationManagement();
        selectOption(mainInputView.selectOption());
    }

    private static void selectOption(char option) {
    }
}
