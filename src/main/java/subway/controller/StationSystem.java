package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InfoMessage;
import subway.view.Menu;

public class StationSystem {

    private MenuInputManager menuInputManager;
    private Scanner scanner;
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
            System.out.println("역 등록");
        }
        if (input.equals("2")) {
            System.out.println("역 삭제");
        }
        if (input.equals("3")) {
            System.out.println("역 조회");
        }
    }

    private void addStation() {
        String name = stationInputManager.getStationName("등록할");
        Station station = new Station(name);
        StationRepository.addStation(station);
        for( Station what : StationRepository.stations()){
            InfoMessage.printInfo(what.getName());
        }

    }

}
