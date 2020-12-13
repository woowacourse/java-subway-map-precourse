package subway;

import output.ScreenManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        ScreenManager screenManager = new ScreenManager(scanner);
        screenManager.startMainScreen();
    }
}
