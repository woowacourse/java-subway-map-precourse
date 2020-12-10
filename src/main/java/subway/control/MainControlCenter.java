package subway.control;

import subway.enums.InitialSetting;
import subway.enums.MainMenu;
import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    StationControlCenter stationControlCenter;
    LineControlCenter lineControlCenter;
    SectionControlCenter sectionControlCenter;

    public MainControlCenter() {
        stationControlCenter = new StationControlCenter();
        lineControlCenter = new LineControlCenter();
        sectionControlCenter = new SectionControlCenter();

        InitialSetting.STATIONS.initializeStations();
        InitialSetting.LINES.initializeLines();
    }

    public static String inputCommand(Scanner scanner) {
        String command = scanner.nextLine();
        System.out.println();
        return command.trim();
    }

    public void startMainControl(Scanner scanner) {
        while (true) {
            showMainMenu();
            String command = inputCommand(scanner);
            getViewByCommand(command, scanner);
        }
    }

    private void showMainMenu() {
        MainView.printMainMenu();
        MainView.askInputMenu();
    }

    private void getViewByCommand(String command, Scanner scanner) {
        if (command.equals(MainMenu.STATION_CONTROL.getCommand())) {
            stationControlCenter.startStationControl(scanner);
            return;
        }
        if (command.equals(MainMenu.LINE_CONTROL.getCommand())) {
            lineControlCenter.startLineControl(scanner);
            return;
        }
        if (command.equals(MainMenu.SECTION_CONTROL.getCommand())) {
            sectionControlCenter.startSectionControl(scanner);
            return;
        }
    }
}
