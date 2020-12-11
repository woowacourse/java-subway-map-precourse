package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.view.Menu;

public class SubwaySystem {

    private Scanner scanner;
    private InputManager inputManager;

    public SubwaySystem(Scanner scanner) {
        inputManager = new InputManager(scanner);

    }

    public void run() {
        while(true){
            Menu.printMenu(MenuItemsRepository.getMainItems());
            String input = inputManager.getMainInput();
            if(input.equals("1")){
                Menu.printMenu(MenuItemsRepository.getStationItems());
            }
            if(input.equals("2")){
                Menu.printMenu(MenuItemsRepository.getLineItems());
            }
            if(input.equals("3")){
                Menu.printMenu(MenuItemsRepository.getSectionItems());
            }
            if(input.equals("4")){
                System.out.println("노선도 출력");
            }
            if(input.equals("Q")){
                return;
            }
        }

    }
}
