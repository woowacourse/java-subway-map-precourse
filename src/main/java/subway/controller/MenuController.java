package subway.controller;

import java.util.Scanner;
import subway.domain.service.LineService;
import subway.view.MenuView;
import utils.Category;

public class MenuController {
    private MenuController() {}

    public static void runProgram(Scanner scanner) {
        MenuView mainView = new MenuView();
        int stopOption = MenuView.RETRY;
        while (stopOption < MenuView.EXIT) {
            mainView.printMenu();
            int selection = mainView.selectMenu(scanner);
            if (selection <= MenuView.EXIT) {
                stopOption = selection;
                continue;
            }
            showSelectedView(selection, scanner);
        }
    }

    private static void showSelectedView(int categoryNumber, Scanner scanner) {
        Category category = Category.values()[categoryNumber];
        MenuView selectedView = new MenuView(category);
        int stopOption = MenuView.RETRY;
        while (stopOption != MenuView.EXIT) {
            selectedView.printMenu();
            int selection = selectedView.selectMenu(scanner);
            if (selection <= MenuView.EXIT) {
                stopOption = selection;
                continue;
            }
            executeSelection(category, selection, scanner);
        }
    }

    public static void executeSelection(Category category, int selection, Scanner scanner) {
        if (category == Category.STATION) {
            StationController.manageStation(scanner, selection);
        }

        if (category == Category.LINE) {
            if (selection == LineController.GET_LIST) {
                LineService.readLineList();
                return;
            }
            LineController.manageLine(scanner, selection);
        }
    }
}
