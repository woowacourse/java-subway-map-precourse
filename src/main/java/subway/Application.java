package subway;

import java.util.Scanner;
import subway.config.AppConfig;
import subway.controller.MainController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        AppConfig.initializeStationLine();
        MainController mainController = new MainController(new InputView(scanner), new OutputView());
        mainController.run();
    }
}
