package subway;

import java.util.Scanner;
import subway.controller.SubwayMapApplicationController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayMapApplicationController.run(scanner);
    }
}
