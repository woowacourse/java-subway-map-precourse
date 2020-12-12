package subway;

import java.util.Scanner;

import subway.controller.SubwayMapController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayMapController.run(scanner);
    }
}
