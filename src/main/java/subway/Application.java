package subway;

import subway.controller.MenuController;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MenuController.scanMenu(scanner);
        Menu.runMenu(MenuController.selectedMenus);
    }
}
