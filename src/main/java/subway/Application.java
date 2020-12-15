package subway;

import java.util.Scanner;
import subway.controller.MainMenuController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainMenuController.main(scanner);
    }
}
