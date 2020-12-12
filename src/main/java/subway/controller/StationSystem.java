package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.ErrorMessage;
import subway.view.InfoMessage;
import subway.view.Menu;

public class StationSystem {
    private MenuInputManager menuInputManager;
    private StationInputManager stationInputManager;

    public StationSystem(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        stationInputManager = new StationInputManager(scanner);

    }

    public void run() {
        while (true) {
            Menu.printMenu(MenuItemsRepository.getStationItems());
            String input = menuInputManager.getStationInput();
            if (input.equals("B")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            addStation();
        }
        if (input.equals("2")) {
            deleteStation();
        }
        if (input.equals("3")) {
            lookupStations();
        }
    }

    private void lookupStations() {
        for (Station station : StationRepository.stations()) {
            InfoMessage.printName(station.getName());
        }
    }

    private void deleteStation() {
        String name = stationInputManager.getStationNameToDelete();
        if (name.contains(ErrorMessage.OUT)) {
            return;
        }
        StationRepository.deleteStation(name);
        InfoMessage.printStationDeleted();
    }

    private void addStation() {
        String name = stationInputManager.getStationNameToAdd("등록할");
        Station station = new Station(name);
        StationRepository.addStation(station);
        InfoMessage.printStationAdded();

    }


}
