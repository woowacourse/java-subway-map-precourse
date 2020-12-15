package view;

import java.util.Scanner;
import controller.MainController;
import utils.ConstantsString;

public class MainView {
    private Scanner scanner;
    private MainController controller;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void showMenu() {
        printMessage(ConstantsString.MAIN_MENU);
    }

    public String input() {
        return scanner.nextLine();
    }

    public void run() {
        showMenu();
        printMessage(ConstantsString.INPUT_MESSAGE);
    }

    public void showLines() {
        printMessage(controller.getAllLinesInfo());
    }
}
