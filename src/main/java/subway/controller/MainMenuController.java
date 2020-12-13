package subway.controller;

import subway.menus.MainMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class MainMenuController {
    private final StationMenuController stationMenuController = new StationMenuController();
    private final LineMenuController lineMenuController = new LineMenuController();
    private final SectionMenuController sectionMenuController = new SectionMenuController();

    public void mappingMainMenu(Scanner scanner) {
        MainMenu selectedOption;
        do {
            OutputView.printMainPage();
            selectedOption = InputView.selectMainMenu(scanner);
            branchBySelectedOption(selectedOption, scanner);
        } while (selectedOption != MainMenu.EXIT_PROGRAM);
    }

    private void branchBySelectedOption(MainMenu selectedOption, Scanner scanner) {
        if (selectedOption.equals(MainMenu.EXIT_PROGRAM)) {
            return;
        }
        if (selectedOption.equals(MainMenu.STATION_MANAGEMENT)) {
            stationMenuController.mappingStationMenu(scanner);
        }
        if (selectedOption.equals(MainMenu.LINE_MANAGEMENT)) {
            lineMenuController.mappingLineMenu(scanner);
        }
        if (selectedOption.equals(MainMenu.SECTION_MANAGEMENT)) {
            sectionMenuController.mappingSectionMenu(scanner);
        }
        if (selectedOption.equals(MainMenu.SHOW_SUBWAY_MAP)) {
            // 노선도 출력
        }
    }
}
