package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.MenuType;

import java.util.Scanner;

import static subway.view.OutputView.*;

public class SubwayMapService {
    private final StationService stationService;
    private final LineStationService lineStationService;
    private final SectionService sectionService;

    public SubwayMapService() {
        stationService = new StationService();
        lineStationService = new LineStationService();
        sectionService = new SectionService();
    }

    public void selectMainMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if(menu.equals(MenuType.MAIN_STATION.getKey())) {
            stationManagement(scanner, lineStation);
        }
        if(menu.equals(MenuType.MAIN_LINE_STATION.getKey())) {
            lineStationManagement(scanner, lineStation);
        }
        if(menu.equals(MenuType.MAIN_SECTION.getKey())) {
            sectionManagement(scanner, lineStation);
        }
        if(menu.equals(MenuType.MAIN_PRINT_LINE_STATION.getKey())) {
            printLineStation(lineStation);
        }
    }

    private void stationManagement(Scanner scanner, LineStationRepository lineStation) {
        printStationManagementMenu();
        String menu = scanner.nextLine();
        stationService.selectStationManagementMenu(scanner, menu, lineStation);
    }

    private void lineStationManagement(Scanner scanner, LineStationRepository lineStation) {
        printLineStationManagementMenu();
        String menu = scanner.nextLine();
        lineStationService.selectLineStationManagementMenu(scanner, menu, lineStation);
    }

    private void sectionManagement(Scanner scanner, LineStationRepository lineStation) {
        printSectionManagementMenu();
        String menu = scanner.nextLine();
        sectionService.selectSectionManagementMenu(scanner, menu, lineStation);
    }

    private void printLineStation(LineStationRepository lineStation) {
        lineStation.printAllLineStation();
    }
}