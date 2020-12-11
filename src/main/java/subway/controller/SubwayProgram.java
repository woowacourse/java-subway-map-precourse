package subway.controller;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.menu.MainMenuType;
import subway.domain.menu.Menu;
import subway.domain.menu.SubMenuType;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayProgram {
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String SECTION = "구간";
    
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

        Line line = new Line("2호선");
        line.init(new Station("교대역"), new Station("역삼역"));
        line.addStationToLine(new Station("강남역"), 2);
        LineRepository.addLine(line);
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
            getStationMenu(mainMenuType, STATION);
            return;
        }
        if (MainMenuType.LINE_MANAGE.equals(mainMenuType)) {
            getLineMenu(mainMenuType, LINE);
            return;
        }
        if (MainMenuType.SECTION_MANAGE.equals(mainMenuType)) {
            getSectionMenu(mainMenuType, SECTION);
            return;
        }
        if (MainMenuType.PRINT_MAP.equals(mainMenuType)) {
            OutputView.printSubwayMap();
        }
    }

    private void getStationMenu(MainMenuType mainMenuType, String subMenuName) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenu(scanner, subMenuName, mainMenuType);
            selectStationMenu(subMenuType);
        }while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void getLineMenu(MainMenuType mainMenuType, String subMenuName) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenu(scanner, subMenuName, mainMenuType);
            selectLineMenu(subMenuType);
        }while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void getSectionMenu(MainMenuType mainMenuType, String subMenuName) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputSectionMenu(scanner, subMenuName, mainMenuType);
            selectSectionMenu(subMenuType);
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
        }
    }

    private void selectLineMenu(Menu lineMenuType) {
        if (SubMenuType.ADD.equals(lineMenuType)) {
            InputView.inputLineNameAdd(scanner);
            return;
        }
        if (SubMenuType.DELETE.equals(lineMenuType)) {
            InputView.inputLineNameDelete(scanner);
            return;
        }
        if (SubMenuType.LIST_PRINT.equals(lineMenuType)) {
            OutputView.printLineList();
        }
    }

    private void selectSectionMenu(Menu sectionMenuType) {
        if (SubMenuType.ADD.equals(sectionMenuType)) {
            InputView.inputSectionAdd(scanner);
            return;
        }
        if (SubMenuType.DELETE.equals(sectionMenuType)) {
            InputView.inputSectionDelete(scanner);
        }
    }







}
