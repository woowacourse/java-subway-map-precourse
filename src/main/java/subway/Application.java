package subway;

import subway.controller.MenuController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MenuController.selectMainMenu(scanner);
    }
}
