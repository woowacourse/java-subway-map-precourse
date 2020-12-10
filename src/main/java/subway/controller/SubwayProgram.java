package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayProgram {
    private static final String STATION = "역";
    private static final String LINE = "노선";
    
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
        
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
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
            getSubMenu(STATION);
            return;
        }
        if (MainMenuType.LINE_MANAGE.equals(mainMenuType)) {
            getSubMenu(LINE);
            return;
        }
    }

    private void getSubMenu(String subMenuName) {
        Menu subMenuType;
        do {
            subMenuType = InputView.inputSubMenu(scanner, subMenuName);
            if (subMenuName.equals(STATION)) {
                selectStationMenu(subMenuType);
            }
            if (subMenuName.equals(LINE)) {
                selectLineMenu(subMenuType);
            }
        }while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void selectStationMenu(Menu stationMenuType) {
        if (SubMenuType.ADD.equals(stationMenuType)) {
            InputView.inputStationNameAdd(scanner);
            return;
        }
        if (SubMenuType.DELETE.equals(stationMenuType)) {
            InputView.inputStationNameDelete(scanner);
            return;
        }
        if (SubMenuType.LIST_PRINT.equals(stationMenuType)) {
            OutputView.printStationList();
            return;
        }
    }

    private void selectLineMenu(Menu lineMenuType) {
        if (SubMenuType.ADD.equals(lineMenuType)) {
            InputView.inputLineNameAdd(scanner);
            return;
        }
    }






}
