package view;

import java.util.Scanner;
import controller.SectionManageController;
import utils.ConstantsString;

public class SectionManageView {
    private Scanner scanner;
    private SectionManageController controller;

    public SectionManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(SectionManageController controller) {
        this.controller = controller;
    }

    public void run() {
        showMenu();
        printMessage(ConstantsString.INPUT_MESSAGE);
        String input = input();
        if (input.equals(ConstantsString.INPUT_BACK)) {
            return;
        }
        while (!controller.validateInput(input)) {
            printMessage(ConstantsString.INVALID_INPUT);
            printMessage(ConstantsString.INPUT_MESSAGE);
            input = input();
        }
        controller.processInput(input);
    }

    private void showMenu() {
        printMessage(ConstantsString.SECTION_MANAGE_MENU);
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public String input() {
        return scanner.nextLine();
    }
}
