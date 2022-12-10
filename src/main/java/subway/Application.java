package subway;

import subway.controllers.MainController;
import subway.domain.Initializer;
import view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.scanner = scanner;
        MainController mainController = new MainController(scanner);
        Initializer.init();
        mainController.run();
    }
}
