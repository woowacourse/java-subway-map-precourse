package subway;

import java.util.Scanner;
import subway.controller.Controller;
import subway.controller.MainController;
import subway.view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final Controller mainController = new MainController(inputView);

        do {
            mainController.run();
        } while (MainController.isRunning);
    }
}
