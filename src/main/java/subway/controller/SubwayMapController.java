package subway.controller;

import java.util.Scanner;

import subway.domain.menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapController {
    public static void run(Scanner scanner) {
        InputView.setScanner(scanner);
    }

    private static void showMenu(Menu menu) {
        OutputView.printMenu(menu);
        try{
            menu.executeMenuItem(InputView.getInput());
        } catch (Exception exception) {
            OutputView.printError(exception);
            showMenu(menu);
        }
    }
}
