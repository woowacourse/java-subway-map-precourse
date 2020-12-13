package subway.controller;

import subway.menus.StationMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class StationMenuController {
    public void mappingStationMenu(Scanner scanner) {
        OutputView.printStationManagePage();
        branchBySelectedOption(InputView.selectStationMenu(scanner));
    }

    private void branchBySelectedOption(StationMenu selectedOption) {
        if (selectedOption.equals(StationMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(StationMenu.STATION_INSERT)) {

        }
        if (selectedOption.equals(StationMenu.STATION_DELETE)) {

        }
        if (selectedOption.equals(StationMenu.STATION_SELECT)) {

        }
    }
}
