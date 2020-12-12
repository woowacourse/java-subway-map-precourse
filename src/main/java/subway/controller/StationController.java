package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.Menu;
import subway.domain.menu.SubMenuType;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {

    private final Scanner scanner;
    private final StationService stationService;

    public StationController(Scanner scanner) {
        this.scanner = scanner;
        stationService = new StationService(scanner);
    }

    public void runStationMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenu(scanner, category, mainMenuType);
            selectStationMenu(subMenuType, category);
        }while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void selectStationMenu(Menu stationMenuType, String category) {
        if (SubMenuType.ADD.equals(stationMenuType)) {
            stationService.addStationInStationRepository(category);
            return;
        }
        if (SubMenuType.DELETE.equals(stationMenuType)) {
            stationService.deleteStationInStationRepository(category);
            return;
        }
        if (SubMenuType.LIST_PRINT.equals(stationMenuType)) {
            OutputView.printStationList();
        }
    }
}
