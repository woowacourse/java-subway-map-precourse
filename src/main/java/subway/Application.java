package subway;

import java.util.Scanner;

import subway.domain.menu.MainMenu;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        MainMenu menu = new MainMenu();
        menu.printMainMenu();
    }
}
