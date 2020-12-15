package subway;

import subway.controller.MenuController;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        run(inputView);
        scanner.close();
    }

    public static void run(InputView inputView) {
        Initializer.set();
        MenuController menuController = new MenuController(inputView);
        boolean ongoingStatus;
        do {
            menuController.scanMenu();
            ongoingStatus = menuController.runMenus();
            menuController.selectedMenus.clear();
        } while(ongoingStatus);
    }
}
