package subway.controller;

import subway.menus.StationMenu;
import subway.service.StationService;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationMenuController {
    StationService stationService;

    public void mappingStationMenu(Scanner scanner) {
        StationOutputView.printStationManagePage();
        stationService = new StationService(scanner);
        branchBySelectedOption(StationInputView.selectStationMenu(scanner));
    }

    private void branchBySelectedOption(StationMenu selectedOption) {
        if (selectedOption.equals(StationMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(StationMenu.STATION_INSERT)) {
            stationService.addStationService();
        }
        if (selectedOption.equals(StationMenu.STATION_DELETE)) {

        }
        if (selectedOption.equals(StationMenu.STATION_SELECT)) {

        }
    }
}
