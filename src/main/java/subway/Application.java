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
        boolean runStatus;
        do {
            MenuController.scanMenu(inputView);
            runStatus = MenuController.runMenus(inputView);
            MenuController.selectedMenus.clear();
        } while(runStatus);
    }
}
