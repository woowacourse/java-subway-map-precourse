package subway.service;

import subway.userinterface.MainView;

import java.util.Scanner;

public class SubwayApplication {

    public static void run(Scanner scanner) {
        MainView.getInstance().printMainMenu();
        MainView.getInstance().getUserInput(scanner);
    }
}
