package subway.controller;

import subway.menus.StationMenu;
import subway.service.StationService;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationMenuController implements Controller{
    private static StationMenuController stationMenuController = new StationMenuController();
    StationService stationService;

    private StationMenuController() {
    }

    public static StationMenuController getInstance() {
        return stationMenuController;
    }

    public void mappingMenu(Scanner scanner) {
        StationOutputView.printStationManagePage();
        stationService = new StationService(scanner);
        branchBySelectedOption(StationInputView.selectStationMenu(scanner));
    }

    private void branchBySelectedOption(StationMenu selectedOption) {
        if (selectedOption.equals(StationMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(StationMenu.STATION_ADD)) {
            stationService.stationAddService();
        }
        if (selectedOption.equals(StationMenu.STATION_DELETE)) {
            stationService.stationDeleteService();
        }
        if (selectedOption.equals(StationMenu.STATION_SELECT)) {
            stationService.showAllStations();
        }
    }
}
