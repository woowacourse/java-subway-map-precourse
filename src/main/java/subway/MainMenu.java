package subway;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private boolean doNext = true;


    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String run() {
        InputView inputView = new InputView(scanner, "main");
        String menuNumber = inputView.nextMenu();
        if (menuNumber.matches("[Qq]")) {
            doNext = false;
        }
        return menuNumber;
    }

    public boolean doNext() {
        return doNext;
    }
}
