package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.view.Menu;

public class SubwaySystem {

    private Scanner scanner;

    public SubwaySystem(Scanner scanner) {
        this.scanner = scanner;

    }

    public void run() {
        Menu.printMenu(MenuItemsRepository.getMainItems());
        String input = scanner.nextLine().trim();
        if(input.equals("1")){
            Menu.printMenu(MenuItemsRepository.getStationItems());
        }
        if(input.equals("2")){
            Menu.printMenu(MenuItemsRepository.getLineItems());
        }
        if(input.equals("3")){
            Menu.printMenu(MenuItemsRepository.getSectionItems());
        }
    }
}
