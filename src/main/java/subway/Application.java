package subway;

import java.util.Scanner;
import subway.controller.MainMenuController;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.registerScanner(scanner);
        MainMenuController.main();
    }
}
