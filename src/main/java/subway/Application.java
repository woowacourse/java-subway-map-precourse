package subway;

import subway.controller.MainController;
import subway.service.InitializationService;
import subway.view.outputview.MainOutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainOutputView mainOutputView = new MainOutputView();
        MainController mainController = new MainController(scanner, mainOutputView);
        InitializationService.init();
        mainController.run();
    }
}
