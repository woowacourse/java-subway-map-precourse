package subway;

import java.util.Scanner;

import subway.manager.StationManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        StationManager stationManager = new StationManager(scanner);
        stationManager.start();
        scanner.close();
    }
}
