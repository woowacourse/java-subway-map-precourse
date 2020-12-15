package subway;

import subway.controller.MainController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController.startProgram(scanner);
        scanner.close();
    }
}
