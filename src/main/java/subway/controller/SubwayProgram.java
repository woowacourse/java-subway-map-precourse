package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayProgram {
    
    private final Scanner scanner;
    
    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
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
            InputView.inputStationNameAdd(scanner);
            return;
        }
        if (StationMenuType.STATION_DELETE.equals(stationMenuType)) {
            InputView.inputStationNameDelete(scanner);
            return;
        }
    }



}
