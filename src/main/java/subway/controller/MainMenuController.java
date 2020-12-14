package subway.controller;

import subway.menus.MainMenu;
import subway.views.OutPutSubwayMap;
import subway.views.mainviews.MainInputView;
import subway.views.mainviews.MainOutputView;

import java.util.Scanner;

public class MainMenuController {
    private static MainMenuController instance = new MainMenuController();
    private final StationMenuController stationMenuController = StationMenuController.getInstance();
    private final LineMenuController lineMenuController = LineMenuController.getInstance();
    private final SectionMenuController sectionMenuController = SectionMenuController.getInstance();

    private MainMenuController() {
    }

    public static MainMenuController getInstance() {
        return instance;
    }

    public void mappingMainMenu(Scanner scanner) {
        MainMenu selectedOption;
        do {
            MainOutputView.printMainPage();
            selectedOption = MainInputView.selectMainMenu(scanner);
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
            OutPutSubwayMap.printAllSubwayMap();
        }
    }
}
