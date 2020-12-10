package subway;

import subway.controller.SubwayController;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        final InputView inputView = new InputView(scanner);
        final SubwayController subwayController = new SubwayController(inputView);

        subwayController.run();
    }
}
