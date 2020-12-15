package subway.controller;

import subway.menus.StationMenu;
import subway.service.stationservice.StationAddService;
import subway.service.stationservice.StationDeleteService;
import subway.service.stationservice.StationsPrintService;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationMenuController implements Controller{
    private static final StationMenuController stationMenuController = new StationMenuController();

    private StationMenuController() {
    }

    public static StationMenuController getInstance() {
        return stationMenuController;
    }

    public void mappingMenu(Scanner scanner) {
        StationOutputView.printStationManagePage();
        branchBySelectedOption(StationInputView.selectStationMenu(scanner), scanner);
    }

    private void branchBySelectedOption(StationMenu selectedOption, Scanner scanner) {
        if (selectedOption.equals(StationMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(StationMenu.STATION_ADD)) {
            StationAddService stationAddService = StationAddService.getInstance();
            stationAddService.stationAddService(scanner);
        }
        if (selectedOption.equals(StationMenu.STATION_DELETE)) {
            StationDeleteService stationDeleteService = StationDeleteService.getInstance();
            stationDeleteService.stationDeleteService(scanner);
        }
        if (selectedOption.equals(StationMenu.STATION_SELECT)) {
            StationsPrintService.showAllStations();
        }
    }
}
