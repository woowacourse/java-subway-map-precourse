package subway.control;

import subway.enums.InitialSetting;
import subway.enums.MainMenu;
import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    StationControlCenter stationControlCenter;
    LineControlCenter lineControlCenter;

    public MainControlCenter() {
        stationControlCenter = new StationControlCenter();
        lineControlCenter = new LineControlCenter();

        InitialSetting.STATIONS.initializeStations();
    }

    public static String inputCommand(Scanner scanner) {
        String command = scanner.nextLine();
        System.out.println();
        return command;
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
    }
}
