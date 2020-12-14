package subway;

import subway.controller.SubwayMapController;
import subway.map.SubwayMapApplication;
import subway.map.SubwayMapInitializer;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        SubwayMapController subwayMapController = SubwayMapInitializer.injectDependencies();
        SubwayMapInitializer.loadDefaultData(subwayMapController);
        SubwayMapApplication subwayMapApplication = new SubwayMapApplication(inputView, subwayMapController);
        subwayMapApplication.run();
        scanner.close();
    }
}
