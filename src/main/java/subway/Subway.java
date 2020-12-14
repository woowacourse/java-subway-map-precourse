package subway;

import subway.view.Input;
import subway.view.MainMenu;
import subway.view.Output;

import java.util.Scanner;

public class Subway {

    public void run(Scanner scanner) {
        MainMenu menu;
        do {
            MainMenu.printMenu();
            menu = chooseMenu(scanner);
            menu.execute(scanner);
            Output.printNewLine();
        } while(menu.isExit());
    }

    private MainMenu chooseMenu(Scanner scanner) {
        try {
            return MainMenu.getMainMenuType(Input.choose(scanner));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu(scanner);
        }
    }
}
