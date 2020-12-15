package subway;

import subway.controller.SubwayMapController;
import subway.initializer.SubwayMapInitializer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayMapInitializer initializer = new SubwayMapInitializer();
        SubwayMapController subwayMapController = new SubwayMapController(scanner);
        try {
            initializer.run();
            subwayMapController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
