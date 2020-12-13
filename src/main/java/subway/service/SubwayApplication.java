package subway.service;

import subway.userinterface.mainmenu.MainMenuView;

import java.util.Scanner;

public class SubwayApplication {

    private static String userSelectMenu = "";

    public static void init() {
        //초기화 함수
    }

    public static void run(Scanner scanner) {
        while (!userSelectMenu.equals("Q")) {
            MainMenuView.getInstance().printMenu();
            userSelectMenu = MainMenuView.getInstance().getUserInput(scanner);
            MainService.getInstance().selectMenu(MainMenuView.mainMenu, userSelectMenu, scanner);
        }
    }
}
