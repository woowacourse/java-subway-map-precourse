package subway;

import java.util.Scanner;
import subway.controller.SubwayMapController;
import subway.views.MainView;


public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayMapController.start(scanner);
    }
}
