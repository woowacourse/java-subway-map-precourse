package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController implements Controller {
    private final Scanner scanner;
    private final StationService stationService;

    public StationController(Scanner scanner) {
        this.scanner = scanner;
        stationService = new StationService(scanner);
    }

    @Override
    public void runMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenuType(scanner, category, mainMenuType);
            selectMenu(subMenuType, category);
        } while (!subMenuType.equals(SubMenuType.BACK));
    }

    @Override
    public void selectMenu(SubMenuType subMenuType, String category) {
        if (SubMenuType.ADD.equals(subMenuType)) {
            stationService.addStationInStationRepository(category);
            return;
        }
        if (SubMenuType.DELETE.equals(subMenuType)) {
            stationService.deleteStationInStationRepository(category);
            return;
        }
        if (SubMenuType.LIST_PRINT.equals(subMenuType)) {
            OutputView.printStationList(category);
        }
    }
}
