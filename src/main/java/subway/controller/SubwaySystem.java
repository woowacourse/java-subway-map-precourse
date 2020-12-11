package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.view.Menu;

public class SubwaySystem {

    private MenuInputManager menuInputManager;
    private StationSystem stationSystem;
    private LineSystem lineSystem;

    public SubwaySystem(Scanner scanner) {
        menuInputManager = new MenuInputManager(scanner);
        stationSystem = new StationSystem(scanner, menuInputManager);
        lineSystem = new LineSystem(scanner,menuInputManager);
    }

    public void run() {
        while(true){
            Menu.printMenu(MenuItemsRepository.getMainItems());
            String input = menuInputManager.getMainInput();
            if(input.equals("Q")){
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if(input.equals("1")){
            stationSystem.run();
        }
        if(input.equals("2")){
            lineSystem.run();
       }
        if(input.equals("3")){
            Menu.printMenu(MenuItemsRepository.getLinkItems());
        }
        if(input.equals("4")){
            System.out.println("노선도 출력");
        }
    }
}
