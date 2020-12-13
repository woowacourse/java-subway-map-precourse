package subway;

import subway.controller.MainController;
import subway.view.InputView;

import java.util.Scanner;

public class Application {

    static {
        SampleDataInitializer.initialStationRepository();
        SampleDataInitializer.initialLineRepository();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.setScanner(scanner);
        MainController.run();
    }

}
