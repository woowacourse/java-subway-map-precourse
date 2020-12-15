package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.util.DummyUtils;
import subway.util.InputUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        DummyUtils.makeDummy();

        InputUtils inputUtils = new InputUtils(scanner);
        MainController mainController = new MainController();
        mainController.run(inputUtils);
    }
}
