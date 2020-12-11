package subway.control;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.enums.MainMenu;
import subway.view.MainView;
import subway.view.SectionView;

import java.util.Scanner;

public class MainControlCenter {

    StationControlCenter stationControlCenter;
    LineControlCenter lineControlCenter;
    SectionControlCenter sectionControlCenter;

    public MainControlCenter() {
        stationControlCenter = new StationControlCenter();
        lineControlCenter = new LineControlCenter();
        sectionControlCenter = new SectionControlCenter();

        StationRepository.initializeStations();;
        LineRepository.initializeLines();
        SectionRepository.initializeSections();
    }

    public static String inputCommand(Scanner scanner) {
        String command = scanner.nextLine();
        System.out.println();
        return command.trim();
    }

    public void startMainControl(Scanner scanner) {
        String view = "";
        while (!view.equalsIgnoreCase("Q")) {
            showMainMenu();
            String command = inputCommand(scanner);
            view = getViewByCommand(command, scanner);
        }
    }

    private void showMainMenu() {
        MainView.printMainMenu();
        MainView.askInputMenu();
    }

    private String getViewByCommand(String command, Scanner scanner) {
        if (command.equals(MainMenu.STATION_CONTROL.getCommand()))
            return stationControlCenter.startStationControl(scanner);
        if (command.equals(MainMenu.LINE_CONTROL.getCommand()))
            return lineControlCenter.startLineControl(scanner);
        if (command.equals(MainMenu.SECTION_CONTROL.getCommand()))
            return sectionControlCenter.startSectionControl(scanner);
        if (command.equals(MainMenu.PRINT_SUBWAY_MAP.getCommand()))
            return SectionView.printSectionList();
        if (command.equalsIgnoreCase(MainMenu.EXIT.getCommand()))
            return MainView.exit();
        return "";
    }
}
