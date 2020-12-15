package subway;

import java.util.Scanner;
import subway.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        MenuController.runProgram(scanner);
    }
}
