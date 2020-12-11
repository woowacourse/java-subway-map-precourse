package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final MainController mainController = new MainController(inputView);

        mainController.run();
    }
}
