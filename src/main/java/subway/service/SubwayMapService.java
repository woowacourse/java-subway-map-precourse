package subway.service;

import subway.domain.LineStationRepository;

import java.util.Scanner;

import static subway.domain.MenuType.*;
import static subway.view.OutputView.*;

public class SubwayMapService extends InputService {
    private final StationService stationService;
    private final LineStationService lineStationService;
    private final SectionService sectionService;

    public SubwayMapService() {
        stationService = new StationService();
        lineStationService = new LineStationService();
        sectionService = new SectionService();
    }

    public void selectMainMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (MAIN_STATION.isKeyEquals(menu)) {
            stationManagement(scanner, lineStation);
        }
        if (MAIN_LINE_STATION.isKeyEquals(menu)) {
            lineStationManagement(scanner, lineStation);
        }
        if (MAIN_SECTION.isKeyEquals(menu)) {
            sectionManagement(scanner, lineStation);
        }
        if (MAIN_PRINT_LINE_STATION.isKeyEquals(menu)) {
            printLineStation(lineStation);
        }
    }

    private void stationManagement(Scanner scanner, LineStationRepository lineStation) {
        printStationManagementMenu();
        String menu = inputSelectMenu(scanner, STATION_MENU_RANGE);
        stationService.selectStationManagementMenu(scanner, menu, lineStation);
    }

    private void lineStationManagement(Scanner scanner, LineStationRepository lineStation) {
        printLineStationManagementMenu();
        String menu = inputSelectMenu(scanner, LINE_STATION_MENU_RANGE);
        lineStationService.selectLineStationManagementMenu(scanner, menu, lineStation);
    }

    private void sectionManagement(Scanner scanner, LineStationRepository lineStation) {
        printSectionManagementMenu();
        String menu = inputSelectMenu(scanner, SECTION_MENU_RANGE);
        sectionService.selectSectionManagementMenu(scanner, menu, lineStation);
    }

    private void printLineStation(LineStationRepository lineStation) {
        lineStation.printAllLineStation();
    }
}