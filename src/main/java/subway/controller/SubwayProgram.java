package subway.controller;

import subway.domain.*;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayProgram {
    
    private final Scanner scanner;
    
    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }


    public void run() {
        MainMenuType mainMenuType;
        do {
            mainMenuType = InputView.inputMainMenu(scanner);
            selectMainMenu(mainMenuType);
        }while (!mainMenuType.equals(MainMenuType.END_PROGRAM));
    }

    private void selectMainMenu(MainMenuType mainMenuType) {
        if (MainMenuType.STATION_MANAGE.equals(mainMenuType)) {
            getStationMenu();
        }
    }

    private void getStationMenu() {
        StationMenuType stationMenuType;
        do {
            stationMenuType = InputView.inputStationMenu(scanner);
            selectStationMenu(stationMenuType);
        }while (!stationMenuType.equals(StationMenuType.BACK));
    }

    private void selectStationMenu(StationMenuType stationMenuType) {
        if (StationMenuType.STATION_ADD.equals(stationMenuType)) {
            InputView.inputStationName(scanner);
        }
    }



}
