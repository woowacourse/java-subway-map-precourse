package subway;

import subway.userinterface.UserController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        UserController.runApp(scanner);
        scanner.close();
    }
}
