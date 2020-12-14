package subway;

import subway.controller.ControllerMapper;
import subway.map.SubwayMapApplication;
import subway.map.SubwayMapInitializer;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.initiate(scanner);
        InputView inputView = InputView.getInstance();
        ControllerMapper controllerMapper = SubwayMapInitializer.injectDependencies();
        SubwayMapApplication subwayMapApplication = new SubwayMapApplication(inputView, controllerMapper);
        subwayMapApplication.run();
        scanner.close();
    }
}
