package view;

import java.util.Scanner;
import controller.LineManageController;
import utils.ConstantsString;

public class LineManageView {
    private LineManageController controller;
    private Scanner scanner;

    public LineManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(LineManageController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        printMessage(ConstantsString.LINE_MANAGE_MENU);
    }

    public void printMessage(String s) {
        System.out.println(s);
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

    public String input() {
        return scanner.nextLine();
    }
}
