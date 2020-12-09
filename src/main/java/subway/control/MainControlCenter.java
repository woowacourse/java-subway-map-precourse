package subway.control;

import subway.domain.Station;
import subway.enums.MainMenu;
import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    StationControlCenter stationControlCenter;

    public MainControlCenter() {
        stationControlCenter = new StationControlCenter();
    }

    public void startMainControl(Scanner scanner) {
        showMainMenu();
        String command = inputCommand(scanner);
        getViewByCommand(command);
    }

    private void showMainMenu() {
        MainView.printMainMenu();
    }

    private String inputCommand(Scanner scanner) {
        MainView.askInputMenu();
        return scanner.nextLine();
    }

    private void getViewByCommand(String command) {
        if (command.equals(MainMenu.STATION_CONTROL.getCommand())) {
            stationControlCenter.startStationControl();
            return;
        }
    }
}
