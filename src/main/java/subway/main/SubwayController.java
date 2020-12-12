package subway.main;

import subway.main.view.MainInputView;
import subway.main.view.MainOutputView;
import subway.station.StationController;

public class SubwayController {
    private static final char STATION_MANAGEMENT = '1';
    private static final char LINE_MANAGEMENT = '2';
    private static final char SECTION_MANAGEMENT = '3';
    private static final char PRINT_LINE_MAP = '4';
    private static final char EXIT_SERVICE = 'Q';

    public static void run(MainInputView mainInputView) {
        MainOutputView.printMainSelection();
        selectOption(mainInputView.selectOption(), mainInputView);
    }

    private static void selectOption(char option, MainInputView mainInputView) {
        if (option == STATION_MANAGEMENT) {
            StationController.stationManagement(mainInputView);
        }
    }
}
