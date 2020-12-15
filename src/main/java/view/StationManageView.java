package view;

import java.util.Scanner;
import controller.StationManageController;
import utils.ConstantsString;

public class StationManageView {

    private Scanner scanner;
    private StationManageController controller;

    public StationManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(StationManageController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        printMessage(ConstantsString.STATION_MANAGE_MENU);
    }

    public void run() {
        showMenu();
        printMessage(ConstantsString.INPUT_MESSAGE);
        String input = input();
        while (!controller.validateInput(input)) {
            printMessage(ConstantsString.INVALID_INPUT);
            printMessage(ConstantsString.INPUT_MESSAGE);
            input = input();
        }
        if (input.equals(ConstantsString.INPUT_BACK)) {
            return;
        }
        controller.processInput(input);
    }


    public void printMessage(String s) {
        System.out.println(s);
    }

    public String input() {
        return scanner.nextLine();
    }
}
