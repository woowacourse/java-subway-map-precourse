package subway.main;

import subway.common.SelectOption;
import subway.line.LineController;
import subway.section.SectionController;
import subway.station.StationController;
import subway.subwaymap.SubwayMapController;
import subway.view.InputView;
import subway.view.MainOutputView;

import java.util.Arrays;
import java.util.List;

public class SubwayController {
    private static final char STATION_MANAGEMENT = '1';
    private static final char LINE_MANAGEMENT = '2';
    private static final char SECTION_MANAGEMENT = '3';
    private static final char PRINT_LINE_MAP = '4';
    private static final char EXIT_SERVICE = 'Q';

    public static void run(InputView inputView) {
        List<Character> optionList = Arrays.asList(STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, PRINT_LINE_MAP, EXIT_SERVICE);

        while (true) {
            MainOutputView.showMainMenu();
            char option = SelectOption.choice(optionList, inputView);

            if (option == EXIT_SERVICE) {
                break;
            }

            navigateSubMenu(option, inputView);
        }
    }

    private static void navigateSubMenu(char option, InputView inputView) {
        if (option == STATION_MANAGEMENT) {
            StationController.stationManagement(inputView);
        }
        if (option == LINE_MANAGEMENT) {
            LineController.lineManagement(inputView);
        }
        if (option == SECTION_MANAGEMENT) {
            SectionController.sectionManagement(inputView);
        }
        if (option == PRINT_LINE_MAP) {
            SubwayMapController.showSubwayMap();
        }
    }
}
