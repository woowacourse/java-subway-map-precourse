package subway;

import subway.map.SubwayMapApplication;
import subway.map.SubwayMapInitializer;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.initiate(scanner);
        SubwayMapApplication subwayMapApplication = SubwayMapInitializer.injectDependencies();
        subwayMapApplication.run();
        scanner.close();
    }
}
