package subway.controller;

import subway.InputView;

import java.util.Scanner;

public class MainMenu {
    public static final String REGEX_QUIT = "[Qq]";
    public static final String KEY_MAIN = "main";
    private final Scanner scanner;
    private boolean doNext = true;


    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String run() {
        InputView inputView = new InputView(scanner, KEY_MAIN);
        String menuNumber = inputView.nextMenu();
        if (menuNumber.matches(REGEX_QUIT)) {
            doNext = false;
        }
        return menuNumber;
    }

    public boolean doNext() {
        return doNext;
    }
}
