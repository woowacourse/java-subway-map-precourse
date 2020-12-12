package subway;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private boolean doNext = true;


    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String menuInputNumber(String userInput, String regex) {
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력을 해주세요(1~4, Q)");
        }
        return userInput;
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
