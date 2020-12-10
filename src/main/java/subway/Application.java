package subway;

import subway.line.LineInitialization;
import subway.station.StationInitialization;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        StationInitialization.setBasicStations();
        LineInitialization.setBasicLines();

        SubwayController.run(scanner);
    }
}
